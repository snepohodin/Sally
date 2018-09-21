package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonPayPalLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='btnLogin']")
    private WebElement logInButton;

    public SalonPayPalLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(logInButton, 20);
    }

    public SalonPayPalReviewPaymentPage login(String userEmail, String userPass) {
        emailField.clear();
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPass);
        logInButton.click();
        return new SalonPayPalReviewPaymentPage(browser);
    }

    public boolean isLoaded() {
        return logInButton.isDisplayed() && emailField.isDisplayed() && passwordField.isDisplayed();
    }
}
