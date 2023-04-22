package cucumber;

import org.openqa.selenium.WebDriver;
import webdriver.WebDriverConfig;

public class ScenarioContextUI {

    private static WebDriverConfig webDriverConfig = new WebDriverConfig();
    private ScenarioReport report;

    public ScenarioContextUI() {
        reset();
    }


    private void reset() {
        report = new ScenarioReport();
        webDriverConfig.driver = null;
    }

    public ScenarioReport getReport() {
        return report;
    }


    private WebDriver getFreshWebdriver() {
        webDriverConfig = new WebDriverConfig("mac", "chrome");
        return webDriverConfig.driver;
    }

    public WebDriver getWebDriver() {
        if (webDriverConfig.driver == null) {
            return getFreshWebdriver();
        } else {
            return webDriverConfig.driver;
        }
    }


}
