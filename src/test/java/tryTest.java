import io.qameta.allure.Description;
import org.example.Annotations.DriverAndLoggerExtension;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.ActionsForDriver.ActionHandler.click;
import static org.example.ActionsForDriver.FindElementHelper.findElement;
import static org.example.lifeCycle.Extension.getDriver;


@DriverAndLoggerExtension
public class tryTest {
    static WebDriver driver = getDriver();

//    @Test
//    @Description("test 1 try")
//    void test1()
//    {
//        System.out.println("test1-step1");
//        //sendKeys(By.className("gLFyf"),"verisoft");
//        //click(By.className("gNO89b"));
//        //driver.findElement(By.className("gLFyf")).sendKeys("verisoft");
//        //driver.findElement(By.xpath("//li[@id='menu-item-51']//a")).click();
//        click(By.xpath("//li[@id='menu-item-958']//a"));
//    }

    @Test
    @Description("test 2 try")
    void test2() {
        WebElement element = findElement(By.xpath("//li[@id='aaa']//a"));
        //click(By.xpath("//li[@id='aaa']//a"));
    }
}
