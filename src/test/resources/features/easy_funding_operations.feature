Feature: Test the 'find a cause' functionality on EasyFunding website

  Scenario Outline: Check if the third cause is present for entered cause

    Given User opens the website

    And Go to the link find a cause

    When user enters the <searchString> and select the third cause if exists

    Then user will be given a confirmation message

    Examples:
      | searchString |
      | abc          |
      | hjk          |