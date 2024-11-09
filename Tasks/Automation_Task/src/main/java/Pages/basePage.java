package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * A generic class all other classes inherit from it which contains some
 * general methods
 */
public class basePage {
    /*A global member for driver*/
    protected WebDriver base_page_driver;

    /**
     * A constructor that take the webdriver of a website
     *
     * @param driver of how to go to through the website
     */
    public basePage(WebDriver driver) {
        base_page_driver = driver;
    }

    /**
     * A generic method that I use it in scroll down in a page
     *
     * @param driver of how to go to through the website
     */
// Method to scroll until the locator is found
    public void scrollUntilLocatorFound(WebDriver driver, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            // Try to find the element
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Element found: " + element.getText());
                    break;  // Exit the loop if element is found
                }
            } catch (NoSuchElementException e) {
                // Scroll down if element is not found
                js.executeScript("window.scrollBy(0, 500000)");
            }
        }
    }


    /**
     * A generic method that I use it in scroll up in a page
     *
     * @param driver of how to go to through the website
     */
    public void scroll_up(WebDriver driver) {
        // Creating JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll up by -500 pixels in the y-axis
        js.executeScript("scroll(0, -500)");
    }

    /**
     * A generic method that I use it to wait of an element to ready to do next action on it
     *
     * @param driver       of how to go to through the website
     * @param time         a specific time of waiting
     * @param element_name which element you want to be waiting
     */
    public void wait_elements(WebDriver driver, int time, By element_name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_name));
    }
}
