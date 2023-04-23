package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(className = "inventory_item")
    private List<WebElement> productItem;

    @FindBy(className = "title")
    private WebElement inventoryTitle;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle(){
        return inventoryTitle.getText();
    }

    public int countTotalProductItem() {
        return getTotalListItem(productItem);
    }



}
