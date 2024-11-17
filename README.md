## Automation Infrastructure README

### Project Overview:
This automation infrastructure project aims to streamline and simplify automated testing processes for web applications using Selenium WebDriver. It provides a set of utility classes and annotations to enhance test automation efficiency and maintainability.

### Setup Instructions:

1. **Dependency Configuration:**
   - Add the following dependency to your project's `pom.xml` file:
     ```xml
     <dependency>
         <groupId>com.example.automation</groupId>
         <artifactId>automation-infra</artifactId>
         <version>1.0.0</version>
         <scope>compile</scope>
     </dependency>
     ```

2. **Configuration File Setup:**
   - Create a `webDriver.properties` file in the `src/main/resources` directory with the following parameters:
      - `driver` (chrome/edge/firefox)
      - `url` (website URL for testing)

### Usage:

1. **Test Class Annotation:**
   - Annotate your test class with `@DriverAndLoggerExtension` for WebDriver and logging extensions:
     ```java
     @DriverAndLoggerExtension
     public class ExampleTest {
         // Your test code here
     }
     ```

2. **Driver Initialization:**
   - Import the driver initialization function in your test and initialize the WebDriver instance:
     ```java
     import static org.example.lifeCycle.Extension.getDriver;
     WebDriver driver = getDriver();
     ```

3. **Performing Actions:**
   - Import action functions to interact with web elements in your tests:
     ```java
     import static org.example.ActionsForDriver.ActionHandler.click;
     import static org.example.ActionsForDriver.FindElementHelper.findElement;

     // Example usage:
     findElement(By.xpath("//button[@id='submit']"));
     click(By.id("loginButton"));
     ```

### After Test Execution:
**Reporting to Allure:**

After test execution, test results and screenshots will be automatically reported to Allure for detailed reporting and analysis.

**Log File Creation:**

A log file named test.log will be generated in the root directory of your project containing detailed logs and information from the test execution.

Ensure to review the Allure reports for comprehensive test results and refer to the test.log file for detailed logging information post-test execution.

### Additional Notes:
- Ensure proper setup and configuration of the WebDriver properties file for accurate test execution.
- Utilize the provided utility classes and annotations to enhance test automation reliability and maintainability.

---

