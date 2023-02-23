package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v85.page.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;

public class FlightConfirmationPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOfLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();
        this.signOfLink.click();
        return price;
    }


}
