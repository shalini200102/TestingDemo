Feature: Search women T-shirt on Myntra

  Scenario: Search Women T-Shirts
    Given user opens browser and myntra website
    When user clicks on women section
    And user searches for "T-shirts"
    Then product list should be displayed