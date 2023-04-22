package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private WebElement product_item;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public int countTotalProductItem() {
        return getTotalListItem((By.ByClassName) product_item);
    }

}
