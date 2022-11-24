@smoke
Feature:switch between currencies US-Euro
  Scenario:Logged User could switch between currencies US-Euro
      Given user go to login page
      When user login with "mbadreldin01@gmail.com" and "Msh2812@"
      And user press on login button
      And user Navigate to Home and Select “Euro” from currency dropdown list
      Then Find all Elements with Euro currency