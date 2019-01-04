package SingleThread;

public class ThreadDemo {

    static class OneThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10 ; i++) {
                System.out.println("Thread " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        OneThread oneThread = new OneThread();
        oneThread.start();
        try {
            oneThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
