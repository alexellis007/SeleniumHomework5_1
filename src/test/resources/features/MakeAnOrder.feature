Feature: E-Shop Automation
  As a user I want to make an order
  and submit it

  Scenario Outline: Make an order and submit
    Given user navigate to the app url
    When user signs in
    And user inputs email with value "<userEmail>"
    And user inputs password with value "<userPassword>"
    And user submits credentials
    And user selects 'Women' menu
    And user selects 'Dresses'
    And user selects 'Casual Dresses'
    And user selects product
    And user adds product to you cart
    And user clicks on 'Proceed to checkout'
    And user verifies cart, clicks on 'Proceed to checkout'
    And user verifies delivery/billing address, clicks on 'Proceed to checkout'
    And user agrees on terns, clicks on 'Proceed to checkout'
    And user verifies delivery carrier, clicks on 'Proceed to checkout'
    And user selects 'Pay by Check'
    And user gets the order amount
    And user clicks to confirm order
    And user checks on order completion
    And user returns to the order
    And user verifies order and total price
    And user logout from account
    Then user logout from account

    Examples:
      |userEmail    |userPassword|
      |ade@gmail.com|qwertyuiop2 |