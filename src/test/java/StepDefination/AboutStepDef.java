package StepDefination;

import Pages.AboutPage;
import Setup.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutStepDef extends Setup {

    AboutPage aboutPage;

    @Given("User visit the gitHub website")
    public void User_visit_the_gitHub_website() {
        driver.get("https://github.com/");
    }

    @When("As a guest user scroll down and click on about")
    public void As_a_guest_user_scroll_down_and_click_on_about() throws InterruptedException {
        aboutPage = new AboutPage(driver);
        aboutPage.doClickAbout();
    }
    @Then("User will be taken to the github about page")
    public void User_will_be_taken_to_the_github_about_page() throws InterruptedException {
        aboutPage = new AboutPage(driver);
        aboutPage.verifyAboutPage();
    }
}
