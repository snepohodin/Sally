package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SalonPayPalReviewPaymentPage extends BasePage {

    @FindBy(xpath = "//input[@id='confirmButtonTop']")
    private WebElement continueButton;

    public SalonPayPalReviewPaymentPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        try {
            sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public SalonOrderConfirmationPage navigateToConfirmationPage(){
        continueButton.click();
        return new SalonOrderConfirmationPage(browser);
    }

    public boolean isLoaded() {
        return continueButton.isDisplayed();
    }
}
