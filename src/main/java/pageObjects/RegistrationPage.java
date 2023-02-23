package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class RegistrationPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameInputBon;

    @FindBy(name = "lastName")
    private WebElement lastNameInputBon;

    @FindBy(name = "email")
    private WebElement userNameInputBon;

    @FindBy(name = "password")
    private WebElement passwordInputBon;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordInputBon;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameInputBon));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameInputBon.sendKeys(firstName);
        this.lastNameInputBon.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password) {
        this.userNameInputBon.sendKeys(userName);
        this.passwordInputBon.sendKeys(password);
        this.confirmPasswordInputBon.sendKeys(password);
    }

    public void clickSubmitBtn() {
        this.submitBtn.click();
    }

}