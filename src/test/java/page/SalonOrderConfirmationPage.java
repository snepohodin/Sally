package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonOrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//h1[@class='confirmation-title']")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//td[@class='order-total_value']")
    private WebElement confirmationPageOrderTotalValue;

    public String getOrderConfirmationOrderTotalValue() {
        return confirmationPageOrderTotalValue.getText();
    }

    public SalonOrderConfirmationPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(confirmationMessage, 10);
    }

    public boolean isLoaded() {
        return  confirmationMessage.isDisplayed();
    }

    public String getConfirmationMessageText () {
        return confirmationMessage.getText();
    }
}
