Feature: Validate Create Order feature
  I want to create a PayPal order using this feature

  Scenario Outline: Validate Create Order feature with valid details
    Given I want to get access token from PayPal api
    When I set currency code as "<currencyCode>" and value as "<currencyValue>"
    And I verify the status as CREATED

#Values from Example will be given to steps mentioned in the scenario
    Examples: 
      | currencyCode | currencyValue |
      | USD          |        500.00 |
      | INR          |        4000.00 |
      | EUR          |        500.00 |
