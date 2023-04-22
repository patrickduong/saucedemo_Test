package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPopUP extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu_button;


    @FindBy(className = "bm-menu")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_link;

    public MenuPopUP(WebDriver driver) {
        super(driver);
    }

    public void logout() throws InterruptedException {
        menu_button.click();
        if (menu.isDisplayed())
            logout_link.click();
    }


}
