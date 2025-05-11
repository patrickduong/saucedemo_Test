package steps;

import constraints.TestConstraints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuPopUP;

import java.util.List;
import java.util.Map;

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

    @When("I add the following products to the cart:")
    public void i_add_the_following_products_to_the_cart(DataTable table) {
        // Convert DataTable to List<Map<columnName, cellValue>>
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String name = row.get("name");
            String price = row.get("price");
            sauceDemoInventoryPage.addProductToCart(name, price);
        }
    }

    @Then("the cart badge should show {int}")
    public void the_cart_badge_should_show(Integer expectedCount) {
        int badgeCount = sauceDemoInventoryPage.getCartBadgeCount();
        if (!(badgeCount == expectedCount)) {
            throw new AssertionError(
                    String.format("Expected cart badge to show %d but was %d", expectedCount, badgeCount)
            );
        }
    }


    @Then("^The Product page display success with (\\d+)")
    public void the_default_product_item_should_show(int totalProductItem) {
        System.out.println("Expected productItem is [" + totalProductItem + "]");
        System.out.println("Actual productItem is [" + sauceDemoInventoryPage.countTotalProductItem() + "]");
        assert totalProductItem == sauceDemoInventoryPage.countTotalProductItem();

    }

    @When("^I logout the web")
    public void i_logout_the_web() {
        menuPopUP.logout();
    }

}
