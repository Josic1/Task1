package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputForms = By.cssSelector("#treemenu>li>ul>li:nth-child(1)>a");
    private By selectDropdownList = By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(4)>a");
    private By inputFormSubmit = By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(5)>a");

    public void clickElement(By clickElement) {
        driver.findElement(clickElement).click();
    }

    public void selectSelectDropdownList() {
        clickElement(inputForms);
        clickElement(selectDropdownList);
    }

    public void selectInputFormSubmit() {
        clickElement(inputForms);
        clickElement(inputFormSubmit);
    }

}
