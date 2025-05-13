@ui @sauceDemoCart
Feature: UI - SauceDemoCart Test

  Scenario Outline: User can add any product to shopping cart and the cart badge update correctly
    Given I login with "<username>"
    When I add the following products to the cart:
      | name                  | price  |
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light | $9.99  |
    Then the cart badge should show 2
    When I logout the web

    Examples:
      | username     |
      | problem_user |

  Scenario Outline: User can view any products that exist in the cart page
    Given I login with "<username>"
    When I add the following products to the cart:
      | name                  | price  |
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light | $9.99  |
    When I view the cart
    Then the cart badge should show 2
    And the cart contains an item "Sauce Labs Backpack" priced "$29.99" with quantity 1
    And the cart contains an item "Sauce Labs Bike Light" priced "$9.99" with quantity 1
    When I logout the web

    Examples:
      | username                |
      | performance_glitch_user |