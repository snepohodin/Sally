package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

public class SalonSmokeTest extends BaseTest {

    @Test
    public void successfulCreditCardPaymentTest() {
        Assert.assertTrue(salonHomePage.isLoaded(),"Sally Salon Home page is not loaded.");

        SalonSearchListingPage salonSearchListingPage = salonHomePage.navigateToSearchListingPage("Salon Services Shampoo Herbal Complex");
        Assert.assertTrue(salonSearchListingPage.isLoaded(),"Salon Search Listing Page is not loaded.");

        SalonProductDescriptionPage salonProductDescriptionPage = salonSearchListingPage.navigateToProductDescriptionPage();
        Assert.assertTrue(salonProductDescriptionPage.isLoaded(),"Salon Product Description Page is not loaded.");

        SalonCartPage salonCartPage = salonProductDescriptionPage.navigateToCart();
        Assert.assertTrue(salonCartPage.isLoaded(),"Salon Cart Page is not loaded.");

        SalonCheckoutLoginPage salonCheckoutLoginPage = salonCartPage.navigateToCheckoutLoginPage();
        Assert.assertTrue(salonCheckoutLoginPage.isLoaded(),"Salon Checkout Login Page is not loaded.");

        SalonShippingPage salonShippingPage = salonCheckoutLoginPage.login("rdmntest@gmail.com","July222@");
        Assert.assertTrue(salonShippingPage.isLoaded(),"Salon Shipping Page is not loaded.");

        SalonPaymentPage salonPaymentPage = salonShippingPage.navigateToPaymentPage();
        Assert.assertTrue(salonPaymentPage.isLoaded(),"Salon Payment Page is not loaded. CC flow.");

        SalonOrderConfirmationPage salonOrderConfirmationPage = salonPaymentPage.navigateToConfirmationPage("000");
        Assert.assertTrue(salonOrderConfirmationPage.isLoaded(),"Salon Confirmation Page is not loaded.");
        Assert.assertEquals(salonOrderConfirmationPage.getConfirmationMessageText(),"Thank you for your order.","Wrong order confirmation message. CC flow.");
    }

    @Test
    public void successfulPayPalPaymentTest() {
        Assert.assertTrue(salonHomePage.isLoaded(),"Sally Salon Home page is not loaded.");

        SalonSearchListingPage salonSearchListingPage = salonHomePage.navigateToSearchListingPage("Salon Services Shampoo Herbal Complex");
        Assert.assertTrue(salonSearchListingPage.isLoaded(),"Salon Search Listing Page is not loaded.");

        SalonProductDescriptionPage salonProductDescriptionPage = salonSearchListingPage.navigateToProductDescriptionPage();
        Assert.assertTrue(salonProductDescriptionPage.isLoaded(),"Salon Product Description Page is not loaded.");

        SalonCartPage salonCartPage = salonProductDescriptionPage.navigateToCart();
        Assert.assertTrue(salonCartPage.isLoaded(),"Salon Cart Page is not loaded.");

        SalonCheckoutLoginPage salonCheckoutLoginPage = salonCartPage.navigateToCheckoutLoginPage();
        Assert.assertTrue(salonCheckoutLoginPage.isLoaded(),"Salon Checkout Login Page is not loaded.");

        SalonShippingPage salonShippingPage = salonCheckoutLoginPage.login("rdmntest@gmail.com","July222@");
        Assert.assertTrue(salonShippingPage.isLoaded(),"Salon Shipping Page is not loaded.");

        SalonPaymentPage salonPaymentPage = salonShippingPage.navigateToPaymentPage();
        Assert.assertTrue(salonPaymentPage.isLoaded(),"Salon Payment Page is not loaded.");

        SalonPayPalCheckoutGuest salonPayPalCheckoutGuest = salonPaymentPage.navigateToPaypalGuestPage();
        Assert.assertTrue(salonPayPalCheckoutGuest.isLoaded(),"Salon PayPal Guest Page is not loaded.");

        SalonPayPalLoginPage salonPayPalLoginPage = salonPayPalCheckoutGuest.navigateToPayPalLoginPage();
        Assert.assertTrue(salonPayPalLoginPage.isLoaded(),"Salon PayPal Login Page is not loaded.");

        SalonPayPalReviewPaymentPage salonPayPalReviewPaymentPage = salonPayPalLoginPage.login("dpritula-buyer@gmail.com","qwepoi786");
        Assert.assertTrue(salonPayPalReviewPaymentPage.isLoaded(),"Salon PayPal Login Page is not loaded.");

        SalonOrderConfirmationPage salonOrderConfirmationPage = salonPayPalReviewPaymentPage.navigateToConfirmationPage();
        Assert.assertTrue(salonOrderConfirmationPage.isLoaded(),"Salon Confirmation Page is not loaded. PayPal flow.");
        Assert.assertEquals(salonOrderConfirmationPage.getConfirmationMessageText(),"Thank you for your order.","Wrong order confirmation message. PayPal flow.");

    }
}
