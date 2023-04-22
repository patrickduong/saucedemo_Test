package steps;

import contraints.TestConstraints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuPopUP;

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
        //need handle wait for page load
    }

    @Then("^The Product page display success with (\\d+)")
    public void verifyTotalProductItem(int productItem) {
        System.out.println("total product is" + productItem);
        System.out.println("total product is" + sauceDemoInventoryPage.countTotalProductItem());
        assert productItem == sauceDemoInventoryPage.countTotalProductItem();


    }

    @When("^I logout the web")
    public void i_logout_the_web() throws InterruptedException {
        menuPopUP.logout();
        //need handle wait for menu item display
        // 1. retry clicking menu
        // 2. execute js script to make logout display 

    }

}
