package tests.searchPageTests;
;
import org.testng.*;
import org.testng.annotations.*;
import pageObjects.search.*;
import tests.infra.*;

public class SearchPageTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResults();
        Assert.assertTrue(size > 0);
    }

}