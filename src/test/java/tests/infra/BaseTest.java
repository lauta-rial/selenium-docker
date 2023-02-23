package tests.infra;

import org.checkerframework.checker.units.qual.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import java.net.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        String host = "localhost";
        MutableCapabilities  desiredCapabilities;
        // Set Chrome as default browser.
        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("FIREFOX")) {
            desiredCapabilities = new FirefoxOptions();
            System.out.println("FireFox Execution");
        } else {
            desiredCapabilities = new ChromeOptions();
            System.out.println("Chrome Execution");
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), desiredCapabilities);

    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }

}
