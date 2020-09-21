package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormSubmitPage {
    WebDriver driver;

    public FormSubmitPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.cssSelector(".form-group:nth-child(2)>div>div>.form-control");
    private By lastName = By.cssSelector(".form-group:nth-child(3)>div>div>.form-control");
    private By e_mail = By.cssSelector(".form-group:nth-child(4)>div>div>.form-control");
    private By phone = By.cssSelector(".form-group:nth-child(5)>div>div>.form-control");
    private By address = By.cssSelector(".form-group:nth-child(6)>div>div>.form-control");
    private By city = By.cssSelector(".form-group:nth-child(7)>div>div>.form-control");
    private By state = By.cssSelector(".form-group:nth-child(8)>div>div>.form-control");
    private By zipCode = By.cssSelector(".form-group:nth-child(9)>div>div>.form-control");
    private By websiteOrDomain = By.cssSelector(".form-group:nth-child(10)>div>div>.form-control");
    private By doYouHaveHosting = By.xpath("//div[@class='form-group']//div[2]//label[1]");
    private By projectDescription = By.cssSelector(".form-group:nth-child(12)>div>div>.form-control");
    private By buttonSent = By.cssSelector(".btn.btn-default");


    public void clickElement(By clickElement) {
        driver.findElement(clickElement).click();
    }

    public void enterText(String text, By toElement) {
        driver.findElement(toElement).sendKeys(text);
    }

    public void selectElement(By selectElement, String visibleText) {
        Select selectState = new Select(driver.findElement(state));
        selectState.selectByVisibleText(visibleText);
    }

    public void contactUsTodayInputForm(String firstname, String lastname, String email, String phone1, String address1, String city1, String zipcode, String websiteDomain, String projectdescription) throws InterruptedException {
        enterText(firstname, firstName);
        enterText(lastname, lastName);
        enterText(email, e_mail);
        enterText(phone1, phone);
        enterText(address1, address);
        enterText(city1, city);
        selectElement(state, "Arizona");
        enterText(zipcode, zipCode);
        enterText(websiteDomain, websiteOrDomain);
        clickElement(doYouHaveHosting);
        enterText(projectdescription, projectDescription);
        clickElement(buttonSent);
    }

}
