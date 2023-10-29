package Pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    @FindBy(className = "flex-1")
    List<WebElement> searchBtn;

    @FindBy(id = "query-builder-test")
    WebElement searchInput;

    @FindBy(xpath = "//div[@class='Box-sc-g0xbh4-0 cgQapc']")
    WebElement countResult;

    @FindBy(className = "search-title")
    List<WebElement> findRepo;


    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void doSearch(String repoName) throws InterruptedException {
        searchBtn.get(3).click();
        Thread.sleep(2000);
        searchInput.sendKeys(repoName);
        searchInput.sendKeys(Keys.ENTER);

    }

    public void countMatchRepo() throws InterruptedException {
        Thread.sleep(5000);
        String actualMatchCount = countResult.getText();
        Assert.assertTrue(actualMatchCount.contains("result"));
    }

    public void verifyRepo(String expectedRepo) throws InterruptedException {
        Thread.sleep(3000);
        String actualRepo = findRepo.get(0).getText();
        Assert.assertEquals(actualRepo,expectedRepo);
    }
}
