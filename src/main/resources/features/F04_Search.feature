@smoke
Feature: F04_Search | User Could search to get product
  Scenario Outline: User could search using product name
    Given user type the search word on search field "<Keyword>"
    When user click on search button
    And There are "<Number>" should be displayed
    Then user find each result contains the search word by keyword "<Keyword>"
    Examples:
      | Keyword | Number |
      | book    | 4      |
      | laptop  | 2      |
      | nike    | 3      |


  Scenario Outline: user could search using sku
    Given user type the search word on search field "<sku>"
    When user click on search button
    And user Click on the product
    Then The product should contains "<sku>" for each product
    Examples:
      | sku       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |

