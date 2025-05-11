@ui @sauceDemo
Feature: UI - SauceDemo Test

  Scenario Outline: User can login successfully with an account to see the PRODUCTS page then logout successfully to see the Login page
    Given I login with "<username>"
    Then The Product page display success with <product_item>
    When I logout the web

    Examples:
      | username                | product_item |
      | standard_user           | 6            |
      | problem_user            | 6            |
      | performance_glitch_user | 6            |

  Scenario Outline: User can add any product to shopping cart and the cart badge update correctly
    Given I login with "<username>"
    When I add the following products to the cart:
      | name                  | price  |
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light | $9.99  |
    Then the cart badge should show 2
    When I logout the web

    Examples:
      | username                |
      | standard_user           |
