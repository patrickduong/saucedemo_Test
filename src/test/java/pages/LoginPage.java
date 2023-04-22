package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username_field;

    @FindBy(id = "password")
    private WebElement password_field;

    @FindBy(id = "login-button")
    private WebElement login_button;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String passWord) {
        username_field.sendKeys(userName);
        password_field.sendKeys(passWord);
        login_button.click();

    }


}
