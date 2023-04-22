package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> product_item;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public int countTotalProductItem() {
        return getTotalListItem(product_item);
//        return product_item.size();
    }

}
