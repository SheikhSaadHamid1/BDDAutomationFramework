@WebTest
Feature: Search Old car feature

  Background: 
    Given user navigates to automobiles section from home page

  Scenario Outline: Search Old car from Automobiles section
    When user select old cars tab
    And user enters "<Keyword>" in keyword field
    And user selects "<Make>" from make dropdown
    And user selects "<Model>" from model dropdown
    And user select "<Body>" from Body Style dropdown
    And user clicks on search button
    Then search results are displayed
    When user clicks on a search result containing "<Model>" value
    Then old car details page is displayed
    And "<NumberPlate>" information is displayed correctly for number plates
    And "<Kilometers>" information is displayed correctly for kilometers
    And "<Body>" information is displayed correctly for car body
    And "<Seats>" information is displayed correctly for seats

    Examples: 
      | Keyword | Make  | Model | Body  | NumberPlate | Kilometers | Seats |
      | MCA84   | Honda | Civic | Sedan | MCA84       | 28,523km   |     5 |
