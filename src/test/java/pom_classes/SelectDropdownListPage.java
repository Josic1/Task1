package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectDropdownListPage {
    WebDriver driver;


    public SelectDropdownListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By selectDay = By.cssSelector(".panel-body>#select-demo");
    private By[] selectStates = new By[]{By.cssSelector("option[value='Florida']"),
            By.cssSelector("option[value='Texas']"), By.cssSelector("option[value='Ohio']")};


    public void waitForElementToBePresent(By element) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 20);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void selectElement(By day, String value) {
        Select selectOption = new Select(driver.findElement(day));
        selectOption.selectByValue(value);
    }

    public void selectTuesday() {
        selectElement(selectDay, "Tuesday");
    }

    public void clickElement(By clickElement) {
        driver.findElement(clickElement).click();
    }

    public void holdCtrl(By element) {
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(element);
        waitForElementToBePresent(element);
        action.keyDown(Keys.CONTROL).click(element1).build().perform();
    }

    public void getAllSelected() throws InterruptedException {
        for (int i = 0; i < selectStates.length; i++) {
            holdCtrl(selectStates[i]);
        }
        clickElement(By.cssSelector(".btn.btn-primary:nth-child(6)"));
    }

    public void getFirstSelected() throws InterruptedException {
        for (int i = 0; i < selectStates.length; i++) {
            holdCtrl(selectStates[i]);
        }
        clickElement(By.cssSelector(".btn.btn-primary:nth-child(5)"));
    }
}
