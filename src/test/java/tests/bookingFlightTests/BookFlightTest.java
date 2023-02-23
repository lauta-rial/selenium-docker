package tests.bookingFlightTests;

import org.testng.*;
import org.testng.annotations.*;
import pageObjects.*;
import tests.infra.*;

public class BookFlightTest extends BaseTest {

    private String noOfPassangers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassangers", "expectedPrice" })
    public void setupParameter(String noOfPassangers, String expectedPrice) {
        this.noOfPassangers = noOfPassangers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCredentials("selenium", "docker");
        registrationPage.clickSubmitBtn();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassangers(noOfPassangers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFLightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);

    }

}
