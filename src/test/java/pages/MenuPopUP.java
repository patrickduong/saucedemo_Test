package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPopUP extends BasePage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;


    @FindBy(className = "bm-menu")
    private WebElement menuOption;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public MenuPopUP(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        menuButton.click();
        if (menuOption.isDisplayed())
            logoutLink.click();
    }


}
