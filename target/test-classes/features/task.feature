Feature:Feature To Test Find Cause
  Scenario Outline: Check cofirmation message about cause
    Given User open the website
    And Go to the link find cause
    When user types <searchString> and select the third cause if exists
    Then user will be given a confirmation message
    Examples:
      |searchString|
      |abc|
      |hjk|