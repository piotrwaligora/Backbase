Feature: Login features frontend

  Scenario: Verify correct user is logged in
    Given User opens login page
    When he login with credentials userName "pwtest@wp.pl" and password "pw123"
    Then user "pwtest" is logged in
    