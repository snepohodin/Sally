package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalonProductDescriptionPage extends BasePage {

    @FindBy(xpath = "//div[@class='pdp-image_link js-main-image']")
    private WebElement productImage;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    private WebElement addToBasketButton;

    @FindBy(xpath = "//a[@class='button mini-cart_button']")
    private WebElement viewBasketButton;

    public SalonProductDescriptionPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        waitUntilElementIsVisible(productImage, 10);
    }

    public SalonCartPage navigateToCart() {
        addToBasketButton.click();
        waitUntilElementIsVisible(viewBasketButton, 10);
        viewBasketButton.click();
        return new SalonCartPage(browser);
    }

    public boolean isLoaded() {
        return productImage.isDisplayed()
                && getCurrentPageTitle().contains("| Shampoo |")
                && getCurrentPageUrl().contains("/hair-care-and-styling/shampoo/");
    }
}
