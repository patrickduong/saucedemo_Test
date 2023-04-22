@ui @saucedemo
Feature: UI - SauceDemo Authentication Test

  Scenario Outline: User can login successfully with an account to see the PRODUCTS page then logout successfully to see the Login page
    Given I login with "<username>"
    Then The Product page display success with <product item>
    When I logout the web

    Examples:
      | username                | product item |
      | standard_user           | 6            |
      | problem_user            | 6            |
      | performance_glitch_user | 6            |