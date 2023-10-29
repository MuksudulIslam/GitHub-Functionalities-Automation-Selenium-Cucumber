package StepDefination;

import Pages.SearchPage;
import Setup.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepDef extends Setup {
    SearchPage searchPage;

    @Given("User first visit the gitHub website")
    public void User_first_visit_the_gitHub_website() {
        driver.get("https://github.com/");
    }
    @When("As a guest user search for a repository {string}")
    public void As_a_guest_user_search_for_a_repository(String repoName) throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.doSearch(repoName);
    }
    @Then("User can see a count matching result")
    public void User_can_see_a_count_matching_result() throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.countMatchRepo();
    }
    @Then("User verify and find the {string}")
    public void User_verify_and_find_the(String expectedRepo) throws InterruptedException {
        searchPage = new SearchPage(driver);
        searchPage.verifyRepo(expectedRepo);
    }
}
