
import midas.GetBookingTest;
import midas.GetBookingsTest;
import midas.TimeFormatTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(GetBookingTest.class,
                TimeFormatTest.class, GetBookingsTest.class);

        int testsRan = result.getRunCount();
        int failedTests = result.getFailureCount();

        for(Failure failure: result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println("Successful tests " + (testsRan-failedTests) + " / " + testsRan);

    }
}
