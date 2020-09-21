package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.FormSubmitPage;
import pom_classes.HomePage;
import pom_classes.SelectDropdownListPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class FormSubmitTest {

    String URL = "https://www.seleniumeasy.com/test";

    WebDriver driver;
    DriverManager driverManager;

    HomePage homePage;
    FormSubmitPage formSubmitPage;

    @BeforeMethod
    public void setup() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verify() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.selectInputFormSubmit();
        formSubmitPage = new FormSubmitPage(driver);
        formSubmitPage.contactUsTodayInputForm("First", "Last", "test@email.com", "850444222", "Address", "City", "25152", "https://www.google.com/", "test");
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitWebDriver();
    }

}
