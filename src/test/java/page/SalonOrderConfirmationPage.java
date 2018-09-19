package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonOrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//h1[@class='confirmation-title']")
    private WebElement confirmationMessage;


    public SalonOrderConfirmationPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(confirmationMessage, 10);
    }

    public boolean isLoaded() {
        return  confirmationMessage.isDisplayed();
    }
}