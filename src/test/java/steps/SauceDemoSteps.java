package steps;

import constraints.TestConstraints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuPopUP;

import java.util.Objects;

import static cucumber.ScenarioHooks.driver;

public class SauceDemoSteps {
    private final LoginPage sauceDemoLoginPage;
    private final InventoryPage sauceDemoInventoryPage;

    private final MenuPopUP menuPopUP;

    public SauceDemoSteps() {

        sauceDemoLoginPage = PageFactory.initElements(driver, LoginPage.class);
        sauceDemoInventoryPage = PageFactory.initElements(driver, InventoryPage.class);
        menuPopUP = PageFactory.initElements(driver, MenuPopUP.class);
    }

    @Given("^I login with \"([^\"]*)\"$")
    public void i_login_with(String userName) {
        sauceDemoLoginPage.login(userName, TestConstraints.DEFAULT_PASSWORD);
    }

    @Then("^The page title display is \"([^\"]*)\"$")
    public void verifyTotalProductItem(String pageTitle) {
        assert Objects.equals(pageTitle, sauceDemoInventoryPage.getPageTitle());
    }

    @Then("^The Product page display success with (\\d+)")
    public void verifyTotalProductItem(int totalProductItem) {
        System.out.println("Expected productItem is [" + totalProductItem + "]");
        System.out.println("Actual productItem is [" + sauceDemoInventoryPage.countTotalProductItem() + "]");
        assert totalProductItem == sauceDemoInventoryPage.countTotalProductItem();

    }

    @When("^I logout the web")
    public void i_logout_the_web() {
        menuPopUP.logout();
    }

}
