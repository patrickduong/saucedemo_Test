package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> productItem;

    @FindBy(className = "title")
    private WebElement inventoryTitle;

    public void addProductToCart(String productName, String productPrice) {
        // 1. Grab all product containers
        List<WebElement> items = driver.findElements(By.cssSelector("div.inventory_item"));

        for (WebElement item : items) {
            // 2. Extract name and price from each container
            String name = item.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText().trim();
            String price = item.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText().trim();

            // 3. If both match, locate the button
            if (name.equals(productName) && price.equals(productPrice)) {
                WebElement btn = item.findElement(By.cssSelector("button.btn_inventory"));
                String btnText = btn.getText().trim();

                // 4. Only click if it's an 'Add to cart' button
                if (btnText.equalsIgnoreCase("Add to cart")) {
                    btn.click();
                } else {
                    // already in cart / says "Remove" — do nothing
                    System.out.printf("Product '%s' already in cart (button shows '%s'), skipping click.%n",
                            productName, btnText);
                }
                return;  // done after handling the matched product
            }
        }

        throw new RuntimeException(
                String.format("Product not found: name='%s', price='%s'", productName, productPrice)
        );
    }

    public int getCartBadgeCount() {
        WebElement badge = driver.findElement(By.cssSelector("span[data-test='shopping-cart-badge']"));
        String text = badge.getText().trim();
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Cart badge did not contain a number: '" + text + "'", e);
        }
    }


    public InventoryPage(final WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return inventoryTitle.getText();
    }

    public int countTotalProductItem() {
        return getTotalListItem(productItem);
    }


}
