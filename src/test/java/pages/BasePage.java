package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    final WebDriver driver;
    public static BasePage currentPage;

    public BasePage(WebDriver driver) {
        currentPage = this;
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void selectDropdownItem(By element, String item) {
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(item);
    }

    public int getTotalListItem(List<WebElement> elements){
        return elements.size();
    }

    public void waitForElementToClick (By element, long timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        clickElement(element);
    }

    public void clickElement(By element){
        driver.findElement(element).click();
    }

}