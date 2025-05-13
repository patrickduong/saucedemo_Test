package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constraints.TestConstraints.TEST_URL;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);

    }

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");


    /**
     * Fill in first name, last name, and ZIP/postal code.
     */
    public void fillCustomerInfo(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        driver.findElement(postalCodeInput).clear();
        driver.findElement(postalCodeInput).sendKeys(zipCode);
    }

    /**
     * Click “Continue” and verify navigation to step two.
     */
    public void continueCheckout() {
        driver.findElement(continueButton).click();
        String url = driver.getCurrentUrl();
        if (!url.equals(TEST_URL + "checkout-step-two.html")) {
            throw new AssertionError(
                    "Expected to navigate to checkout-step-two.html but was: " + url
            );
        }
    }

    /**
     * Click “Cancel” and verify navigation back to cart.
     */

    public void cancelCheckout() {
        driver.findElement(cancelButton).click();
        String url = driver.getCurrentUrl();
        if (!url.equals(TEST_URL + "cart.html")) {
            throw new AssertionError(
                    "Expected to navigate to cart.html but was: " + url
            );
        }
    }

}
