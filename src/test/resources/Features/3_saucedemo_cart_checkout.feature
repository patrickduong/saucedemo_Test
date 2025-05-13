@ui @sauceDemoCartCheckout
Feature: UI - SauceDemoCartCheckout Test

  Scenario Outline: User can add any product for proceed to checkout step One and step Two
    Given I login with "<username>"
    When I add the following products to the cart:
      | name                  | price  |
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light | $9.99  |
    Then I view the cart
    And I proceed to checkout
    Then the cart badge should show 2
    When I fill checkout form with first name "Jane", last name "Smith", zip code "54321"
    And I "continue" the checkout process

    Examples:
      | username      |
      | standard_user |

# not stable for checking - need handle return page objects between cancel and continue
