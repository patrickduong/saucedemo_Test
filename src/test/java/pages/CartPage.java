package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By cartItemsLocator = By.cssSelector("div.cart_list div.cart_item");

//    private final By continueShopButtonLocator = By.cssSelector("[data-test='continue-shopping']");
//    private final By checkOutButtonLocator = By.cssSelector("[data-test='checkout']");

    public static class CartItem {
        public final String name;
        public final String price;
        public final int quantity;

        public CartItem(String name, String price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
    }

    public List<CartItem> getAllCartItems() {
        List<CartItem> items = new ArrayList<>();
        List<WebElement> elements = driver.findElements(cartItemsLocator);

        for (WebElement el : elements) {
            String qtyText = el.findElement(By.cssSelector("[data-test='item-quantity']")).getText().trim();
            int quantity = Integer.parseInt(qtyText);
            String name = el.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText().trim();
            String price = el.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText().trim();

            items.add(new CartItem(name, price, quantity));
        }
        return items;
    }

    public boolean isItemInCart(String expectedName, String expectedPrice, int expectedQuantity) {
        return getAllCartItems().stream().anyMatch(item ->
                item.name.equals(expectedName) &&
                        item.price.equals(expectedPrice) &&
                        item.quantity == expectedQuantity
        );
    }

    public void verifyItemPresent(String expectedName, String expectedPrice, int expectedQuantity) {
        if (!isItemInCart(expectedName, expectedPrice, expectedQuantity)) {
            throw new AssertionError(
                    String.format("Cart does not contain item [%s, %s, qty=%d]",
                            expectedName, expectedPrice, expectedQuantity));
        }
    }

}
