Feature: Article features frontend

  Scenario: Verify article is added
    Given User login with credentials userName "pwtest@wp.pl" and password "pw123"
    When user clicks on new article
    And he fill in all article fields and press publish article
    Then article is added and contains text "java is sometimes hard to understand"
    