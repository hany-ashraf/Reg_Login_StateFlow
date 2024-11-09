package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class initializeTests {

    public WebDriver base_test_driver;

    public initializeTests() {

    }

    /**
     * A method that check which the browser you want and setup it
     * @param browser a passed variable the type of browser
     */
    @BeforeClass
    @Parameters({"browser", "url"})  // Parameters from the testng.xml
    public void open_browser(String browser, String url)
    {
        if(browser.equals("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            base_test_driver = new ChromeDriver();
            base_test_driver.get(url);
            base_test_driver.manage().window().maximize();
        }
        else if(browser.equals("firfox"))
        {
            WebDriverManager.firefoxdriver().setup();
            base_test_driver = new FirefoxDriver();
            base_test_driver.get(url);
            base_test_driver.manage().window().maximize();
        }
    }

    /**
     * A method that close the browser after finish of done the test cases
     */
    @AfterClass
    public void close_browser()
    {
        base_test_driver.close();
    }
}
