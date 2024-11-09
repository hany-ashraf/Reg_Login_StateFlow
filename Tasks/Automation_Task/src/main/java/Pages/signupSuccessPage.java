package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupSuccessPage extends basePage{

    public signupSuccessPage(WebDriver driver) {
        super(driver);
    }

    public By getSuccessMessage() {
        return successMessage;
    }

    //Locator for Success message
    private By successMessage = By.xpath("//strong[contains(text(), 'Your account has been created')]");
}
