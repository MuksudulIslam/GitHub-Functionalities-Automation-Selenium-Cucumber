package Pages;

import Utils.Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AboutPage {
    WebDriver driver;
    @FindBy(className = "Link--secondary")
    List<WebElement> aboutLink;

    @FindBy(className = "h1-mktg")
    WebElement headAboutPage;

    public AboutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doClickAbout() throws InterruptedException {
        Utils.doScroll(driver,0, 15000);
        Thread.sleep(2000);
        aboutLink.get(48).click();
    }

    public void verifyAboutPage() throws InterruptedException {
        Thread.sleep(5000);
        String actualAboutPageURL  = driver.getCurrentUrl();
        Assert.assertTrue(actualAboutPageURL.contains("about"));
        Thread.sleep(3000);
        String actualAboutPageHeading = headAboutPage.getText();
        Assert.assertTrue(actualAboutPageHeading.contains("build from here"));
    }


}
