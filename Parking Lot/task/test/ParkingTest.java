import org.hyperskill.hstest.v6.stage.BaseStageTest;
import org.hyperskill.hstest.v6.testcase.CheckResult;
import org.hyperskill.hstest.v6.testcase.TestCase;
import parking.MainKt;

import java.util.Arrays;
import java.util.List;


public class ParkingTest extends BaseStageTest {
    public ParkingTest() {
        super(MainKt.class);
    }

    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase()
        );
    }

    public CheckResult check(String reply, Object clue) {
        String text =
            "White car has parked.\n" +
            "Yellow car left the parking lot.\n" +
            "Green car just parked here.";

        if (!reply.trim().equals(text.trim())) {
            return CheckResult.FALSE(
                "You printed the wrong text! " +
                    "See the example.");
        } else {
            return CheckResult.TRUE;
        }
    }
}
