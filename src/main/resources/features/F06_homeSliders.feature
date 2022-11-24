@smoke
Feature: F06_homeSliders | user should be directed to Page needed from slider
  Scenario: first slider is clickable on home page
    Given user select Nokia Lumia slider
    Then  Nokia Lumia page will be opened


  Scenario: second slider is clickable on home page
    Given user Select on iphone slider
    Then iphone page will be opened
