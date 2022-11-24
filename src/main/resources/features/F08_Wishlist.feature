@smoke
Feature: F08_Wishlist | users add products to wishlist

  Scenario: user add "HTC One M8 Android L 5.0 Lollipop" to his wishlist successfully
    Given Select HTC and click on wishlist button
    Then green background and success msg will be displayed


  Scenario: "HTC One M8 Android L 5.0 Lollipop" quantity of user's wishlist should be grater than 0
    Given Select HTC and click on wishlist button
    And Check the product quantity
    Then Verify that the quantity is grater than zero
