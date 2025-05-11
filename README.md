# sauceDemo_Test

## Preface:
+ This project is a basic test framework for UI automation using cucumber, selenium and build tool gradle
+ You should be familiar with Java programming language (intermediate level)
+ Knowledge should know
  + OOP (Object Oriented Programming) -> it will apply with Page Object modal
  + Selenium factory/ WebDriverConfig -> it will apply for managing execution single browser that in local setup
  + Cucumber with ScenarioContext, ScenarioHooks, ScenarioReport and Test Runner -> it will apply for BDD style

## Prerequisites
+ Setup Java SDK version: 1.8+ or later (default build is version 15)
+ Plugins: See the build.gradle for dependencies installation
+ Selenium usage should be familiar with @findby: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
+ First use framework please run gradle build test for download all required dependencies.
+ Recommendation for using intelliJ IDE for install Java and manage lib

## Test Execution Flow
1. Start the browser-driver base on defined properties in gradle.properties via build.gradle run (run with gradle)
2. Init BasePage and navigate to TestURL (defined in constraints/TestConstraints)
3. Execute all defined steps in steps directory
4. Generate cucumber report by from Cucumber_report.json
   + Default generating 3 types html, json and xml (for later use with other report plugins) - see at target/cucumber-reports
   + I include the plugin called spacialcircumstances.gradle-cucumber-reporting that will generate report at target/cucumber-html-report (base on the Cucumber_report.json above)

## To use the framework
1. Please install any items mentioned at Prerequisites
2. For executing using cli - set the default approach 1 for using firefox only
    - Open terminal type ```gradle clean test```
    - Wait until the execution done then click on the link ```~/target/cucumber-html-reports/overview-features.html```
    - It should display the report result
3. For executing single feature file just select the feature file then run


## NOTE
+ Feel free to update and customise this template base your own knowledge
+ This test project has problem with check page title when running directly with gradle.build or via cli. Temporary commented a step in feature file.
+ The web app has issue with Chrome browser that need to handle popup will need to handle later
+ Please upgrade chrome driver and firefox driver to latest as link below (choose the correct driver that support CPU type)
  + https://googlechromelabs.github.io/chrome-for-testing/
  + https://github.com/mozilla/geckodriver/releases