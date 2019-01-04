import MultiThread.PiCalculator;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.omg.SendingContext.RunTime;

import java.math.BigDecimal;

public class PiTester {
    private static String correctValue = "3.141592653589793238462643383279502884197";

    @Test
    @BeforeAll
    public static void correctValue()
    {
        System.out.println(correctValue);
    }



    /*@Test
    @Ignore
    public void PiTest()
    {
        PiCalculator piCalculator = new PiCalculator();
        String correctValue = "3.141592653589793238462643383279502884197";
        String calculatePi = piCalculator.getPiBIgDecimal(100000000).toPlainString().substring(0,41);

        System.out.printf("correct value   [%s]\n", correctValue);
        System.out.printf("calculate value [%s]\n", calculatePi);
    }*/
    @Test
    public void PiTestMultiThread() {
        PiCalculator piCalculator = new PiCalculator();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(piCalculator.getPiParallel(80000000l, cores));

    }
    @Test
    public void PiTestMultiThreadWithExecutorRunnable() {
        PiCalculator piCalculator = new PiCalculator();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(piCalculator.getPiByExecutorRunnable(80000000l, cores).toPlainString().substring(0,41));
    }
    @Test
    public void PiTestMultiThreadWithExecutorCallable() {
        PiCalculator piCalculator = new PiCalculator();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(piCalculator.getPiByExecutorCallable(80000000l, cores).toPlainString().substring(0,41));
    }


}
