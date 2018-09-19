package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SalonSearchListingPage extends BasePage {

    @FindBy(xpath = "//span[@class='breadcrumb-element breadcrumb-result_text']")
    private WebElement searchResultTextBar;

    @FindBy(xpath = "//li[@class='tile js-tile']")
    private List<WebElement> searchProductBlock;

    @FindBy(xpath = "//div[@class='tile-image_container js-tile-image']")
    private WebElement productLink;


    public SalonSearchListingPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(searchResultTextBar, 10);
    }

    public SalonProductDescriptionPage navigateToProductDescriptionPage() {
        productLink.click();
        return new SalonProductDescriptionPage(browser);
    }

    public boolean isLoaded() {
        return searchResultTextBar.isDisplayed()
                && getCurrentPageTitle().contains("Salon Global Navigation")
                && getCurrentPageUrl().contains("/s/salon-services/search?q=");
    }
}
