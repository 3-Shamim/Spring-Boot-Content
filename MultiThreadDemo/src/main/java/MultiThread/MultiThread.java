package MultiThread;

public class MultiThread {

    public MultiThread() {
        PiCalculator piCalculator = new PiCalculator();
        System.out.println(piCalculator.getPi(100));
        System.out.println(piCalculator.getPi(1000));
        System.out.println(piCalculator.getPi(10000));
        System.out.println(piCalculator.getPi(100000));
        System.out.println(piCalculator.getPi(1000000));
    }

    public static void main(String[] args) {
        new MultiThread();
    }
}
