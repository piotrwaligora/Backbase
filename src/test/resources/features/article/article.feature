Feature: Article features

  Scenario: Backend: Verify article is added
    Given BE: User login with credentials userName "pwtest@wp.pl" and password "pw123"
    When user adds article with data: "pwTitle5", "pwDescription5" and "pwBody5"
    Then article is added

  Scenario: Frontend: Verify article is added
    Given FE: User login with credentials userName "pwtest@wp.pl" and password "pw123"
    When user clicks on new article
    And he fill in all article fields and press publish article
    Then article is added and contains text "java is sometimes hard to understand"


  Scenario: Frontend: Verify article is added with empty data
    Given FE: User login with credentials userName "pwtest@wp.pl" and password "pw123"
    When user clicks on new article
    And he adds new articles with empty fields
      | title    | about    | text    | tags             |
      | pwTitle1 | pwAbout1 | pwText1 | pwTag10, pwTag11 |
      | pwTitle2 |          | pwText2 | pwTag20, pwTag21 |
      | pwTitle3 | pwAbout3 |         | pwTag30, pwTag31 |
      | pwTitle4 | pwAbout4 | pwText4 |                  |
    Then articles are previewed on home page
      | title    | about    | tags             |
      | pwTitle4 | pwAbout4 |                  |
      | pwTitle3 | pwAbout3 | pwTag30, pwTag31 |
      | pwTitle2 |          | pwTag20, pwTag21 |
      | pwTitle1 | pwAbout1 | pwTag10, pwTag11 |

