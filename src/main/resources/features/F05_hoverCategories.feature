@smoke
Feature: F05_hoverCategories | user hover on main categories, Then select random one of the three sub cateogries

  Scenario: user could hover and select main categories and sub cateogries
    Given user select main category and ascertain that the sub categories are displayed
    When user select sub category or select the main category
    Then Check the Name