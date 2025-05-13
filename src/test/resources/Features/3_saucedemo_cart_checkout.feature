@ui @sauceDemoCartCheckout
Feature: UI - SauceDemoCartCheckout Test

  Scenario: Check out on step one and step two
    Given I login with "standard_user"
    When I add the following products to the cart:
      | name                  | price  |
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light | $9.99  |
    Then I view the cart
    And I proceed to checkout
    Then the cart badge should show 2
    When I fill checkout form with first name "Jane", last name "Smith", zip code "54321"
    And I "continue" the checkout process
# not stable for checking - need handle return page objects between cancel and continue
