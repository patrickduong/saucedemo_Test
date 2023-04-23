# saucedemo_Test

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

## Test Execution Flow
1. Start the browser-driver base on defined properties in gradle.properties via build.gradle run (run with gradle)
2. Init BasePage and navigate to TestURL (defined in constraints/TestConstraints)
3. Execute all defined steps in steps directory
4. Generate cucumber report by from Cucumber_report.json
   + Default generating 3 types html, json and xml (for later use with other report plugins) - see at target/cucumber-reports
   + I include the plugin called spacialcircumstances.gradle-cucumber-reporting that will generate report at target/cucumber-html-report (base on the Cucumber_report.json above)

## NOTE
+ Feel free to update and customise this template base your own knowledge