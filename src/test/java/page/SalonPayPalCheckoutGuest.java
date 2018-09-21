package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonPayPalCheckoutGuest extends BasePage {

    @FindBy(xpath = "//a[@ng-click='logWebviewLoginClickWrapper(); redirect()']")
    private WebElement logInButton;

    public SalonPayPalCheckoutGuest(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(logInButton, 20);
    }

    public SalonPayPalLoginPage navigateToPayPalLoginPage() {
        logInButton.click();
        return new SalonPayPalLoginPage(browser);
    }

    public boolean isLoaded() {
        return logInButton.isDisplayed() && getCurrentPageUrl().contains("/checkout/guest");
    }
}
