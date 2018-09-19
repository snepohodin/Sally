package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonCartPage extends BasePage {

    @FindBy(xpath = "//button[@class='cart-actions_button cart-actions_proceed']")
    private WebElement proceedToCheckOutButton;

    public SalonCartPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(proceedToCheckOutButton, 10);
    }

    public boolean isLoaded() {
        return proceedToCheckOutButton.isDisplayed()
                && getCurrentPageUrl().contains("/cart?lang=");
    }

    public SalonCheckoutLoginPage navigateToCheckoutLoginPage() {
        proceedToCheckOutButton.click();
        return new SalonCheckoutLoginPage(browser);
    }
}
