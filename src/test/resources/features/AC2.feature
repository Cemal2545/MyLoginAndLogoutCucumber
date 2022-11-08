@PRF-617
Feature: While login invalid and empty field situaion

  Background:
    Given The user is on the login page
    @PRF-604
    Scenario Outline: User can not login with invalid username or password
      When The user tries to login with "<username>" and "<password>"
      Then "Invalid user name or password." message should be displayed for invalid credentials

      Examples:
        | username        | password    |
        | salesmanager101 | 123         |
        | 1235            | UserUser123 |
        | storemanager51  | aad3412!    |
        | asdaw           | sdf323'+%   |
        | user1           | sdf323'+%   |
  @PRF-605
    Scenario Outline: User doesn't fill one of the field
      When The field of "<username>" or "<password>" is empty
      Then "Lütfen bu alanı doldurun." message should be displayed from username field

      Examples:
        | username        | password    |
        |                 | UserUser123 |


  @PRF-606
  Scenario Outline: User doesn't fill one of the field
    When The field of "<username>" or "<password>" is empty
    Then "Lütfen bu alanı doldurun." message should be displayed from password field

    Examples:
      | username        | password    |
      | salesmanager101 |             |
      | storemanager51  |             |
      | user1           |             |

    @PRF-607
    Scenario Outline: User doesn't fill both of the fields
      When "<username>" and "<password>" fields are empty
      Then "Lütfen bu alanı doldurun." message should be displayed from username field

      Examples:
        | username        | password    |
        |                 |             |

  @PRF-608
  Scenario Outline: Password credentials are given as bullet points
    When user enters a "<password>"
    Then Then password credentials are shown as bullet points
    Examples:
      | password    |
      | UserUser123 |

  @PRF-609
    Scenario: Check forgotPassword button
      When User clicks on forgotPassword button
      Then User should go to Forgot Password page

  @PRF-610
    Scenario: User can change his/her password
      When User is on the Forgot Password Page
      When User enters  valid username and email
      Then User should change his/her password

  @PRF-611
  Scenario: User can change his/her password
    When User is on the Forgot Password Page
    When User enters  invalid username and email
    Then User should see There is no active user with username or email address message .

  @PRF-612
  Scenario: User can change his/her password
    When User is on the Forgot Password Page
    When User enters nothing
    Then Lütfen bu alanı doldurun. message should be displayed


  @PRF-613
  Scenario Outline: Verifying Remember Me Buttons

    When User enters his/her  "<username>" and "<password>" on the fields
    And User clicks to the the RememberMe button
    And User clicks the loginbutton
    And User clicks the logout button on the right corner of the page
    Then User should be able to see the his/her "<username>" and password typed in the boxes

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |
      | user1           | UserUser123 |



  @PRF-614
    Scenario: User hits enter button on keyword after entering username
      When User enters his/her username and hits enter
      Then User should be on password field

  @PRF-615
    Scenario: User hits enter button on keyboard after entering credentials
      When User enters credentials and hits enter
      Then User should be on Dashboard page

  @PRF-616
    Scenario Outline: User should see his/her name on right top of the Dashboard Page
      When User logins with "<username>" and "<password>" after User should see his/her username on right top of the the Dashboard


      Examples:
        | username        | password    |
        | salesmanager101 | UserUser123 |
        | storemanager51  | UserUser123 |
        | user1           | UserUser123 |


