# Reg_Login_StateFlow

Test Automation Script for User Registration and Login
This repository contains a test automation script that verifies the functionality of user registration and login processes. The script is written in Java and uses Selenium WebDriver, TestNG for testing, and ExtentReports for generating reports.

Project Structure
Base/initializeTests.java: Base setup class that initializes the WebDriver and provides common setup functions.
Pages/: Contains Page Object Model (POM) classes for the different pages involved in the test:
basePage: Base page with shared elements and utilities.
signupPage: Page for user registration elements and actions.
loginPage: Page for user login elements and actions.
signupSuccessPage: Page for verifying successful registration.
testCases/tests.java: Contains the main test cases for user registration and login.
Test Cases
The following test cases are implemented:

User Registration (testRegistration)

Tests the user registration process with data-driven input.
Verifies the success message on successful registration.
Requires manual solving of reCAPTCHA during execution.
User Login (testLogin)

Tests the login process using valid credentials.
Uses assertions to check login success.
Extent Reports
ExtentReports is used to generate detailed test reports, which are saved as ExtentReport.html in the root directory. The report logs the status of each test step, and the result of each test case is shown as PASS or FAIL.

Prerequisites
Java JDK 8 or above
Selenium WebDriver
TestNG
ExtentReports library
Installation
Clone this repository.
Import the project into an IDE like IntelliJ IDEA or Eclipse.
Install necessary dependencies by adding them to your pom.xml (for Maven projects):
xml
Copy code
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.0.0</version>
</dependency>
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.4.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.9</version>
</dependency>
Running the Tests
Ensure that the WebDriver path is set up in initializeTests.java.
Use the TestNG configuration to run the tests:
Run the tests.java file as a TestNG suite.
After execution, open ExtentReport.html to view the test results.
Key Components of the Script
Data-Driven Testing: testRegistration and testLogin use the DataDriven.DataProcess class to provide input data via a TestNG data provider.
ExtentReports Integration: Each test step logs the result to ExtentReports for easy tracking and reporting.
Assertions: testRegistration checks the success message text to verify registration status.
Notes
The script includes a Thread.sleep(20000) to allow manual solving of CAPTCHA. Adjust the wait time if needed.
Incomplete login assertions are noted in testLogin and should be implemented as required.
Author
Hany Ashraf
