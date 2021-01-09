Feature: Validate Get Order feature
  I want to get a PayPal order usering this feature

  Scenario Outline: Validate Get Order feature with valid details
    Given I want to get access token from PayPal api
    When I get order from the paypal api
    And I verify the status code as "<statusCode>"

    Examples: 
      | statusCode |
      |        300 |
      |        200 |
      |        310 |
      |        510 |
