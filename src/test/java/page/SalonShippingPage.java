package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonShippingPage extends BasePage {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement proceedToPaymentButton;

    @FindBy(xpath = "//span[@class='form-row_label_toggle h-toggle']")
    private WebElement useThisAddressForBillingCheckbox;

    @FindBy(xpath = "//div[@class='checkout-sidebar']")
    private WebElement checkoutSidebar;


    public SalonShippingPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(checkoutSidebar, 10);
    }

    public boolean isLoaded() {
        return proceedToPaymentButton.isDisplayed();
    }

    public SalonPaymentPage navigateToPaymentPage() {
        ((JavascriptExecutor)browser).executeScript("arguments[0].scrollIntoView();", proceedToPaymentButton);
        useThisAddressForBillingCheckbox.click();
        proceedToPaymentButton.click();
        return new SalonPaymentPage(browser);
    }
}
