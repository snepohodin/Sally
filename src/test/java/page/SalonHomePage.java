package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonHomePage extends BasePage{

    @FindBy(xpath = "//img[@alt='Sally Salon Services']")
    private WebElement logo;

    @FindBy(xpath = "//input[contains(@class,'tau-header-search-field')]")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'tau-header-search-submit')]")
    private WebElement searchSubmitButton;

    public SalonHomePage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(logo, 10);
    }

    public boolean isLoaded() {
        return logo.isDisplayed()
                && getCurrentPageTitle().contains("Salon Products & Equipment | Professional Beauty | Salon Services")
                && getCurrentPageUrl().contains("development-ukweb-sally.demandware.net/on/demandware.store/Sites-salon-services-Site");
    }

    public SalonSearchListingPage navigateToSearchListingPage(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchSubmitButton.click();
        return new SalonSearchListingPage(browser);
    }
}
