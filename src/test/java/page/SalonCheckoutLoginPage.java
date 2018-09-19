package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SalonCheckoutLoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Enter Email Here']")
    private WebElement loginEmailField;

    @FindBy(xpath = "//input[@placeholder='Enter Password Here']")
    private WebElement loginPasswordField;

    @FindBy(xpath = "//button[@name='dwfrm_login_login']")
    private WebElement signInButton;

    public SalonCheckoutLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(loginEmailField, 10);
    }

    public SalonShippingPage login(String userEmail, String userPass) {
        loginEmailField.sendKeys(userEmail);
        loginPasswordField.sendKeys(userPass);
        signInButton.click();
        return new SalonShippingPage(browser);
    }

    public boolean isLoaded() {
        return loginEmailField.isDisplayed()
                && getCurrentPageTitle().contains("My Account Login")
                && getCurrentPageUrl().contains("/checkout?lang=");
    }
}
