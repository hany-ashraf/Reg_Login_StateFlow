package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage{

    public loginPage(WebDriver driver) {
        super(driver);
    }
    public By getEmailAddress() {
        return emailAddress;
    }

    public By getPassword() {
        return password;
    }

    public By getCheckBox() {
        return checkBox;
    }

    public By getLoginButton() {
        return loginButton;
    }

    //Locator for user email address
    private By emailAddress = By.xpath("//input[@name='email']\n");
    //Locator for User Password
    private By password = By.cssSelector("input[name='password']\n");
    //check box of remember me
    private By checkBox = By.xpath("//*[@id='rememberchb']");
    //Locator for loginButton
    private By loginButton = By.xpath("//span[text()='Login']");


}
