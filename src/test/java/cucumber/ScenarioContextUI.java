package cucumber;

import org.openqa.selenium.WebDriver;
import webdriver.WebDriverConfig;

public class ScenarioContextUI {


    private static WebDriverConfig webDriverConfig = new WebDriverConfig();
    private ScenarioReport report;

    private String DEFAULT_OS ;
    private String DEFAULT_DRIVER ;

    public ScenarioContextUI(String os, String browserDriver) {
        reset();
        DEFAULT_OS = os;
        DEFAULT_DRIVER = browserDriver;
    }


    private void reset() {
        report = new ScenarioReport();
        webDriverConfig.driver = null;
    }

    public ScenarioReport getReport() {
        return report;
    }


    private WebDriver getFreshWebdriver() {
        //temporary hardcoded with mac and chrome when running with feature file
        DEFAULT_OS = System.getProperty("defaultos","mac");
        DEFAULT_DRIVER = System.getProperty("defaultbrowserdriver","chrome");
        //cannot pass gradle properties via variables always return null
        System.out.println("********DEFAULT_OS: " +  System.getProperty("defaultos") + "***");
        System.out.println("********DEFAULT_DRIVER: " + System.getProperty("defaultbrowserdriver") + "***");
        webDriverConfig = new WebDriverConfig(DEFAULT_OS, DEFAULT_DRIVER);
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
