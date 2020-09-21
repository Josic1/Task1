package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_classes.HomePage;
import pom_classes.SelectDropdownListPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;
import selenium_core.DriverType;

import java.util.concurrent.TimeUnit;

public class SelectDropdownListTest {

    String URL = "https://www.seleniumeasy.com/test";

    WebDriver driver;
    DriverManager driverManager;
    HomePage homePage;
    SelectDropdownListPage selectDropdownListPage;

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
        homePage.selectSelectDropdownList();
        selectDropdownListPage = new SelectDropdownListPage(driver);
        selectDropdownListPage.selectTuesday();
        selectDropdownListPage.getAllSelected();
        selectDropdownListPage.getFirstSelected();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitWebDriver();
    }

}
