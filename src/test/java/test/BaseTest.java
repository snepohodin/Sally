package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.SalonHomePage;

public class BaseTest {
    WebDriver browser;
    SalonHomePage salonHomePage;

    @Parameters({"envURL"})
    @BeforeMethod
    public void beforeMethod(@Optional("https://development-ukweb-sally.demandware.net/s/sally-beauty/home?lang=en_GB") String envURL) {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(envURL);
        salonHomePage = new SalonHomePage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }
}
