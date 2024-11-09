package testCases;

import Base.initializeTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.*;

public class tests extends initializeTests {

    static ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport.html");

    @BeforeTest
    public void beforeTest(){
        extent.attachReporter(spark);
    }

    public initializeTests initialize;
    public basePage base;
    public signupPage signup;
    public loginPage login;
    public signupSuccessPage signup_success_page;


    @BeforeClass
    public void setUp() {
        // Initialize the driver and page objects
        initialize = new initializeTests();  // Assuming this is a method in initializeTests that sets up base_test_driver
        signup = new signupPage(base_test_driver);
        login = new loginPage(base_test_driver);
        signup_success_page = new signupSuccessPage(base_test_driver);
    }


    @Test(dataProvider = "TestDriven", dataProviderClass = DataDriven.DataProcess.class)
    public void testRegistration(String firstName, String lastName, String country, String phone, String Email, String password) throws InterruptedException {
        ExtentTest test = extent.createTest("Registration").assignAuthor("Hany Ashraf");

        // Perform registration actions
        base_test_driver.findElement(signup.getFirstName()).sendKeys(firstName);
        base_test_driver.findElement(signup.getLastName()).sendKeys(lastName);
        base_test_driver.findElement(signup.getDropdownTrigger()).click();
        signup.setSelectedCountry(country);
        base_test_driver.findElement(signup.getWriteCountry()).sendKeys(country);
        base_test_driver.findElement(signup.getCountryName()).click();
        base_test_driver.findElement(signup.getPhoneNumber()).sendKeys(phone);
        base_test_driver.findElement(signup.getUserEmail()).sendKeys(Email);
        base_test_driver.findElement(signup.getUserPassword()).sendKeys(password);
        // Pause for manual reCAPTCHA solving
        Thread.sleep(20000);  // Wait for 20 seconds to manually solve the CAPTCHA

        //base_test_driver.findElement(signup.getRecaptcha()).click();
        base_test_driver.findElement(signup.getSubmit()).click();

        // Verify success
        WebElement successMessage = base_test_driver.findElement(signup_success_page.getSuccessMessage());
        Boolean result = successMessage.getText().equals("Your account has been created");
        if (result) {
            test.log(Status.PASS, "Status of Registration: " + successMessage.getText());
        } else {
            Assert.assertTrue(result, "The success message text did not match!");
            test.log(Status.FAIL, "Status of Registration:  " + successMessage.getText());
        }
    }

    @Test(dependsOnMethods = "testRegistration" , dataProvider = "TestDriven", dataProviderClass = DataDriven.DataProcess.class)
    public void testLogin(String firstName, String lastName, String country, String phone, String Email, String password) {
        ExtentTest test = extent.createTest("Login").assignAuthor("Hany Ashraf");

        // Perform login actions
        base_test_driver.findElement(login.getEmailAddress()).sendKeys(Email);
        base_test_driver.findElement(login.getPassword()).sendKeys(password);
        base_test_driver.findElement(login.getCheckBox()).click();
        base_test_driver.findElement(login.getLoginButton()).click();

        // Add assertions as needed for login verification

        /*
            //Assertion !!

         */

        test.log(Status.FAIL, "Status of Login:  ");

    }

    @AfterTest
    public void afterTest(){
        extent.flush();
    }

}
