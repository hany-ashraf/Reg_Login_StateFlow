package Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signupPage extends basePage{
    /**
     * A constructor that take the webdriver of a website
     * @param driver of how to go to through the website
     */
    public signupPage(WebDriver driver) {
        super(driver);
    }

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getDropdownTrigger() {
        return dropdownTrigger;
    }

    public By getWriteCountry() {
        return writeCountry;
    }

    public By getCountryName() {
        return countryName;
    }

    public By getPhoneNumber() {
        return phoneNumber;
    }

    public By getUserEmail() {
        return userEmail;
    }

    public By getUserPassword() {
        return userPassword;
    }

    public By getRecaptcha() {
        return recaptcha;
    }

    public By getSubmit() {
        return submit;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    private String selectedCountry;

    /*Global members of some locator*/
    private By firstName = By.cssSelector("input[name='first_name']");
    private By lastName = By.cssSelector("input[name='last_name']");
    //Click locator to open dropdown list
    private By dropdownTrigger  = By.xpath("//div[@class='filter-option']//div[@class='filter-option-inner']//div[@class='filter-option-inner-inner' and text()='Select Country']");
    //Input your country in search box
    private By writeCountry = By.cssSelector("input[aria-label='Search']");
    //search about your country
    private By countryName = By.xpath("//span[@class='text-dark' and contains(text(), '"+selectedCountry+"')]/strong");
    //Locator of Phone number field
    private By phoneNumber = By.xpath("//input[@name='phone']");
    //Locator of User Email Field
    private By userEmail = By.xpath("//input[@name='user_email']");
    //Locator of user password
    private By userPassword = By.cssSelector("input.form-control[name='password']");
    //Another technique
    public By iframe = By.xpath("//iframe[@title='reCAPTCHA']");
    //Locator of recaptcha click
    private By recaptcha = By.xpath("//div[@class='recaptcha-checkbox-border']");
    //Locator of submission button
    private By submit = By.cssSelector("button[type='submit']");

}
