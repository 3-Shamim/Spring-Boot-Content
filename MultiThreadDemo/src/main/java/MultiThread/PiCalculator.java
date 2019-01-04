package MultiThread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class PiCalculator {

    private static final BigDecimal FOUR = new BigDecimal(4);
    private long term;

    private BigDecimal result = BigDecimal.ZERO;
    private synchronized void addResult(BigDecimal otherResult)
    {
        result = result.add(otherResult);
    }

    public double getPi(int terms) {
        double sum = 0.0;
        for (int t = 1; t <= terms; t++) {
            long denominator = t * 2 - 1;

            if (t % 2 == 0) {
                sum -= 1.0 / denominator;
            } else sum += 1.0 / denominator;
        }
        return sum * 4;
    }

    public BigDecimal getPiBIgDecimal(int terms) {
        BigDecimal sum = BigDecimal.ZERO;
        for (int t = 1; t <= terms; t++) {
            long denominator = t * 2 - 1;

            if (t % 2 == 0) {
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.FLOOR));
            } else sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, BigDecimal.ROUND_FLOOR));
        }
        return sum.multiply(FOUR);
    }

    private BigDecimal getPiBIgDecimalMultiThread(long start, long terms) {
        BigDecimal sum = BigDecimal.ZERO;
        for (long t = start; t <= terms + start; t++) {
            long denominator = t * 2 - 1;

            if (t % 2 == 0) {
                sum = sum.subtract(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, RoundingMode.FLOOR));
            } else sum = sum.add(BigDecimal.ONE.divide(new BigDecimal(denominator), 100, BigDecimal.ROUND_FLOOR));
        }
        return sum.multiply(FOUR);
    }

    public BigDecimal getPiParallel(long terms, int cores) {

        term =  terms/cores;
        long extraTerms = terms % cores;

        Thread threads[] = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            long starter =  1 + (terms * i / cores);
            if(i == cores - 1)
                term = term + extraTerms;
            threads[i] = new Thread(()->{
                BigDecimal calculatePi = getPiBIgDecimalMultiThread(starter, term);
                addResult(calculatePi);
            });
            threads[i].start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*Thread t1 = new Thread(() -> {
            BigDecimal calculatePi1 = getPiBIgDecimalMultiThread(1, (terms/2));
            addResult(calculatePi1);
        });

        Thread t2 = new Thread(() -> {
            BigDecimal calculatePi2 = getPiBIgDecimalMultiThread(terms/2 + 1, terms/2);
            addResult(calculatePi2);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return  result;
    }
    public BigDecimal getPiByExecutorRunnable(long terms, int cores)
    {
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        result = BigDecimal.ZERO;

        term =  terms/cores;
        long extraTerms = terms % cores;

        for (int i = 0; i < cores; i++) {
            long starter = 1 + (term * i);
            if (i == cores - 1) {
                term += extraTerms;
            }
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    BigDecimal calculatePi = getPiBIgDecimalMultiThread(starter, term);
                    addResult(calculatePi);
                }
            });
        }

        executor.shutdown(); // No More Thread Are Accepted !

        try {
            executor.awaitTermination(10l, TimeUnit.SECONDS); //  This is for Thread waiting time !
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termination :" + executor.isTerminated());

        return result;
    }
    public BigDecimal getPiByExecutorCallable(long terms, int cores)
    {
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        result = BigDecimal.ZERO;
        Future<BigDecimal> futures[] = new Future[cores];

        term =  terms/cores;
        long extraTerms = terms % cores;

        for (int i = 0; i < cores; i++) {
            long starter = 1 + (term * i);
            if (i == cores - 1) {
                term += extraTerms;
            }
            futures[i] =  executor.submit(new Callable<BigDecimal>() {
                @Override
                public BigDecimal call() throws Exception {
                    return getPiBIgDecimalMultiThread(starter, term);
                }
            });
        }

        executor.shutdown(); // No More Thread Are Accepted !

        try {
            executor.awaitTermination(10l, TimeUnit.SECONDS); //  This is for Thread waiting time !
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termination :" + executor.isTerminated());

        try{
            for (Future<BigDecimal> future: futures) {
                result = result.add(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }



    public BigDecimal getPiByStreamLamda() {

        // Need to do code for get PI by Stream !

        return result;
    }
}
