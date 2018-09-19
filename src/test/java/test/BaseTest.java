package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.SalonHomePage;

public class BaseTest {
    WebDriver browser;
    SalonHomePage salonHomePage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://development-ukweb-sally.demandware.net/on/demandware.store/Sites-salon-services-Site");
        salonHomePage = new SalonHomePage(browser);
    }

//    @AfterMethod
//    public void afterMethod() {
//        browser.close();
//    }
}
