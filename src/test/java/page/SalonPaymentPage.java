package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SalonPaymentPage extends BasePage {

    @FindBy(xpath = "//label[@for='is-CREDIT_CARD']")
    private WebElement creditCardLabel;

    @FindBy(xpath = "//select[@id='creditCardList']")
    private WebElement selectFromSavedCardsDropdown;

    @FindBy(xpath = "//input[contains(@class,'input-text js-cardcvn_saved')]")
    private WebElement securityCodeField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitOrderButton;

    public SalonPaymentPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(creditCardLabel, 10);
    }

    public SalonOrderConfirmationPage navigateToConfirmationPage(String cvv){
        Select dropdown = new Select(selectFromSavedCardsDropdown);
        dropdown.selectByIndex(1);
        securityCodeField.sendKeys(cvv);
        submitOrderButton.click();
        return new SalonOrderConfirmationPage(browser);
    }


    public boolean isLoaded() {
        return creditCardLabel.isDisplayed();
    }
}
