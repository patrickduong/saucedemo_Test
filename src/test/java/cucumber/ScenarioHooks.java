package cucumber;

import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import java.io.IOException;

import static contraints.TestConstraints.TEST_URL;

public class ScenarioHooks {

    private static final ScenarioContextUI contextUI = new ScenarioContextUI();
    public static WebDriver driver = contextUI.getWebDriver();

    @BeforeAll
    public static void before_all() {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.navigateTo(TEST_URL);
    }

    @AfterAll
    public static void after_all() {
        contextUI.getWebDriver().quit();
    }

    @Before("@ui")
    public void setupForUI() {

    }

    @After("@ui")
    public void tearDownForUi(Scenario scenario) throws IOException {
        contextUI.getReport().write(scenario);
        contextUI.getReport().captureFailScenario(scenario, driver);

    }


}
