package steps;

import constraints.TestConstraints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.List;
import java.util.Map;

import static cucumber.ScenarioHooks.driver;

public class SauceDemoSteps {
    private final LoginPage sauceDemoLoginPage;
    private final InventoryPage sauceDemoInventoryPage;
    private final MenuPopUP menuPopUP;
    private final CartPage sauceDemoCartPage;

    private final CheckoutStepOnePage sauceDemoCheckoutStepOncePage;

    public SauceDemoSteps() {

        sauceDemoLoginPage = PageFactory.initElements(driver, LoginPage.class);
        sauceDemoInventoryPage = PageFactory.initElements(driver, InventoryPage.class);
        menuPopUP = PageFactory.initElements(driver, MenuPopUP.class);
        sauceDemoCartPage = PageFactory.initElements(driver, CartPage.class);
        sauceDemoCheckoutStepOncePage = PageFactory.initElements(driver, CheckoutStepOnePage.class);
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

    @And("the cart contains an item {string} priced {string} with quantity {int}")
    public void cart_contains_expected_item(String name, String price, Integer qty) {
        sauceDemoCartPage.verifyItemPresent(name, price, qty);
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


    @And("^I proceed to checkout")
    public void i_proceed_checkout() {
        driver.findElement(By.cssSelector("[data-test='checkout']")).click();
    }


    @When("I fill checkout form with first name {string}, last name {string}, zip code {string}")
    public void i_fill_checkout_form(String first, String last, String zip) {
        sauceDemoCheckoutStepOncePage.fillCustomerInfo(first, last, zip);
    }

    @And("I {string} the checkout process")
    public void i_choose_action(String action) {
        if (action.equalsIgnoreCase("continue")) {
            sauceDemoCheckoutStepOncePage.continueCheckout();
        } else if (action.equalsIgnoreCase("cancel")) {
            sauceDemoCheckoutStepOncePage.cancelCheckout();
        } else {
            throw new IllegalArgumentException("Unknown action: " + action);
        }
        driver.quit();
    }

    @Given("I am on the checkout step one page")
    public void i_am_on_checkout_step_one() {

    }

    @Given("I am on the checkout step two page")
    public void i_am_on_checkout_step_two() {

    }

    @Given("I am on the inventory page")
    public void i_am_on_inventory() {

    }

    @Given("I am on the cart page")
    public void i_am_on_cart() {

    }

    @When("I view the cart")
    public void i_view_the_Cart() {
        driver.findElement(By.cssSelector("span[data-test='shopping-cart-badge']")).click();
    }
}
