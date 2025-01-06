import io.qameta.allure.Description;
import org.example.Annotations.DriverAndLoggerExtension;
import org.example.lifeCycle.NetworkCallLoggerExtension;
import org.example.lifeCycle.NetworkLoggerExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.example.lifeCycle.Extension.getDriver;

@DriverAndLoggerExtension
@ExtendWith(NetworkLoggerExtension.class)
public class tryTest {
    static WebDriver driver = getDriver();

    @Test
    @Description
    void test1()
    {
        Assertions.assertTrue(5==3);
    }
}
