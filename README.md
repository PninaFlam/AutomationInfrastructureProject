# Project README

## Overview
This project contains classes related to handling actions for a driver using Selenium WebDriver.

## ActionHandler Class
- Manages actions like click, sendKeys, and isDisplayed on web elements.
- Uses WaitUtility for element synchronization and FindElementHelper for finding elements.

## FindElementHelper Class
- Helps in finding web elements using Selenium WebDriver.
- Scrolls the element into view before returning it.

## Browser Package
Contains classes related to browser setup and WebDriver management.

### ChromeDriverFactory Class
- Implements WebDriverFactory interface to create ChromeDriver instances.

### EdgeDriverFactory Class
- Implements WebDriverFactory interface to create EdgeDriver instances.

### FirefoxDriverFactory Class
- Implements WebDriverFactory interface to create FirefoxDriver instances.

### InitDriver Class
- Initializes the WebDriver based on properties loaded from 'webDriver.properties'.

### WebDriverCreate Class
- Creates the appropriate WebDriver based on the driver type specified in properties.

### WebDriverFactory Interface
- Defines a method to create WebDriver instances.

### WebDriverManager Class
- Manages WebDriver settings like window maximization, URL navigation, and implicit wait.

## LifeCycle Package
Contains classes related to test execution lifecycle management.

### Extension Class
- Implements JUnit 5 extension interfaces for setup and teardown operations.
- Initializes WebDriver before all tests and quits it after all tests.

### LogExtension Class
- Manages logging for test execution.

### RetryExtension Class
- Implements retry mechanism for failed tests.

### TestWatcherProject Class
- Monitors test execution and handles success, failure, abortion, and disabled scenarios.

## Utils Package
Contains utility classes for various functionalities.

### PropertiesLoader Class
- Loads properties from a file.

### Screenshot Class
- Captures screenshots during test failures.

### WaitUtility Class
- Provides methods for waiting for elements to be clickable, visible, or present.
