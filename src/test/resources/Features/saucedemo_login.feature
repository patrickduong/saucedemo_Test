@ui @saucedemo
Feature: UI - SauceDemo Authentication Test

  Scenario Outline: User can login successfully with an account to see the PRODUCTS page then logout successfully to see the Login page
    Given I login with "<username>"
#    Then The page title display is "<page_title>"
    Then The Product page display success with <product_item>
    When I logout the web

    Examples:
      | username                | product_item | page_title
      | standard_user           | 6            | Products
      | problem_user            | 6            | Products
      | performance_glitch_user | 6            | Products