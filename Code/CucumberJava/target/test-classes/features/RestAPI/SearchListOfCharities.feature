@APITest
Feature: Search List of Charities

  Scenario Outline: Search a Charity from List of Charities
    Given user set TradeMe sandbox API URI
    When user send Get http request on "<Endpoint>"
    Then API responds <StatusCode> status code
    And List of charities are displayed
    And List contains "<Charity>" in Description

    Examples: 
      | Endpoint           | StatusCode | Charity |
      | /v1/Charities.json |        200 | St John |
