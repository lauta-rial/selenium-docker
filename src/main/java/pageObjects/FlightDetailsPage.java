package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passangers;

    @FindBy(name = "findFlights")
    private WebElement submit;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectPassangers(String noOfPassangers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(passangers));
        Select select = new Select(passangers);
        select.selectByVisibleText(noOfPassangers);
    }

    public void goToFindFlightsPage() {
        this.submit.click();
    }


}
