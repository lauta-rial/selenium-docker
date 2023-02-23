package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class RegistrationConfirmationPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @FindBy(partialLinkText = "Flights")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToFlightDetailsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(signInLink));
        this.flightsLink.click();
    }

}