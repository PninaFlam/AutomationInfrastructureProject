import io.qameta.allure.Description;
import org.example.lifeCycle.Extension;
import org.example.lifeCycle.TestWatcherProject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.example.ActionsForDriver.ActionHandler.click;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith({TestWatcherProject.class, Extension.class})
public class tryTest {
    static WebDriver driver = Extension.getDriver();

    @Test
    @Description("test 1 try")
    void test1()
    {
        System.out.println("test1-step1");
        //sendKeys(By.className("gLFyf"),"verisoft");
        //click(By.className("gNO89b"));
        //driver.findElement(By.className("gLFyf")).sendKeys("verisoft");
        //driver.findElement(By.xpath("//li[@id='menu-item-51']//a")).click();
        click(By.xpath("//li[@id='menu-item-958']//a"));
    }

    @Test
    @Description("test 2 try")
    void test2()
    {
        assertTrue(1==2);
    }
}
