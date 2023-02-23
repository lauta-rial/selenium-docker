package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import java.time.*;

public class FindFlightPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement fistSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void submitFindFLightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(fistSubmitBtn));
        this.fistSubmitBtn.click();
    }

    public void goToFlightConfirmationPage() {
        this.wait.until(ExpectedConditions.visibilityOf(secondSubmitBtn));
        this.secondSubmitBtn.click();
    }

}
