package pageObjects.search;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.*;
import java.util.*;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchTxt;

    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText="Videos")
    private WebElement videosLink;

    @FindBy(className="tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void gotTo() {
        this.driver.get("http://duckduckgo.com");
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideos() {
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        this.videosLink.click();
    }

    public int getResults() {
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return this.allVideos.size();
    }

}
