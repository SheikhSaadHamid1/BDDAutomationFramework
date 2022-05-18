@APITest
Feature: Create a new listing

  Scenario Outline: User can create a new listing in a specific category
    Given user provides valid "<ConsumerKey>","<ConsumerSecret>","<AccessToken>", "<TokenSecret>" with "<RequestHeader>" and body
    When user sends post request on "<Endpoint>"
    Then API responds with <StatusCode>
    And user gets success message and listing id

    Examples: 
      | ConsumerKey                      | ConsumerSecret                   | AccessToken                      | TokenSecret                      | RequestHeader    | Endpoint                                    | StatusCode |
      | CAECAFC6DBF6FD0564EB7BEC3B3F0586 | CF0890BB1FCF8BF7B3623445431963E3 | EB8EE51D8C6C668FDFCA281C940B7288 | 05929E860D7A30A69F0AC98D3C3A41D8 | application/json | https://api.tmsandbox.co.nz/v1/Selling.json |        200 |
