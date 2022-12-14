@PRF-617
Feature: Login With parameters and Scenario Outline

  Background:
    Given The user is on the login page
@PRF-603
  Scenario Outline:
    When The user logs in as a "<userType>"
    Then The user is on the "<pageSubTitle>" page

    Examples:
      | userType      | pageSubTitle    |
      | Driver        | Quick Launchpad |
      | Sales Manager | Dashboard       |
      | Store Manager | Dashboard       |