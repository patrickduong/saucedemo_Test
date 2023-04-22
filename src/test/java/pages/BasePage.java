package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

    final WebDriver driver;
    public static BasePage currentPage;

    public BasePage(WebDriver driver) {
        currentPage = this;
        this.driver = driver;
    }

    public String getPageTitle() {
        return currentPage.driver.getTitle();
    }

    public void navigateTo(String url) {
        currentPage.driver.navigate().to(url);
    }

    public void scrollPage(String position) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        switch (position) {
            case "top" -> js.executeScript("window.scrollTo(0,0)");
            case "middle" -> js.executeScript("window.scrollTo(0,600)");
            case "bottom" -> js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }
    }

    public void scrollUntilElementVisible(By element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(element));
    }

    public void selectDropdownItem(By element, String filter) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(filter);
    }

    public int getTotalListItem(By element){
        List<WebElement> elements = driver.findElements(element);
        return elements.size();
    }




    public void clickLink(By element){
        driver.findElement(element).click();
    }

}