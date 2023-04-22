package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static contraints.TestConstraints.*;

public class WebDriverConfig {
    public WebDriver driver;
    protected final static String DEFAULT_WINOS_RESOURCE_DIR = System.getProperty("user.dir") + "\\src\\main\\resources\\winos\\";
    protected final static String DEFAULT_MACOS_RESOURCE_DIR = System.getProperty("user.dir") + "/src/main/resources/macos/";
    protected final static String CHROME_DRIVER = "webdriver.chrome.driver";
    protected final static String FIREFOX_DRIVER = "webdriver.firefox.driver";
    protected final static String EDGE_DRIVER = "webdriver.edge.driver";


    public WebDriverConfig(String os, String browserType) {
        if (os.equals("window") && !browserType.equals("")) {
            initBrowserDriverOnWin(browserType);
        } else initBrowserDriverOnMac(browserType);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SLOW_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MEDIUM_TIMEOUT));
    }

    public WebDriverConfig() {

    }


    private void initBrowserDriverOnWin(String browserType) {
        switch (browserType) {
            case "chrome" -> {
                System.setProperty(CHROME_DRIVER, DEFAULT_WINOS_RESOURCE_DIR + "chromedriver.exe");
                setChromeDriver();
            }
            case "firefox" -> {
                System.setProperty(FIREFOX_DRIVER, DEFAULT_WINOS_RESOURCE_DIR + "geckodriver.exe");
                setFireFoxDriver();
            }
            case "edge" -> {
                System.setProperty(EDGE_DRIVER, DEFAULT_WINOS_RESOURCE_DIR + "msedgedriver.exe");
                setEdgeDriver();
            }
        }
    }

    private void initBrowserDriverOnMac(String browserType) {
        switch (browserType) {
            case "chrome" -> {
                System.setProperty(CHROME_DRIVER, DEFAULT_MACOS_RESOURCE_DIR + "chromedriver");
                setChromeDriver();
            }
            case "firefox" -> {
                System.setProperty(FIREFOX_DRIVER, DEFAULT_MACOS_RESOURCE_DIR + "geckodriver");
                setFireFoxDriver();
            }
            case "edge" -> {
                System.setProperty(EDGE_DRIVER, DEFAULT_MACOS_RESOURCE_DIR + "msedgedriver");
                setEdgeDriver();
            }
        }

    }

    private void setChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en-US");
        prefs.put("download.default_directory", System.getProperty("user.dir") + "/src/test/downLoadTestDir");
        prefs.put("profile.default_content_setting_values.cookies", 1);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");
        options.addArguments("window-size=1920,1080");
        options.addArguments("no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--remote-allow-origins=*");
        if (Boolean.parseBoolean(System.getProperty("chromeHeadless"))) {
            options.addArguments("headless");
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    private void setFireFoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    private void setEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

}