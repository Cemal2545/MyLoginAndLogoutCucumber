@PRF-624
Feature: Logout Functionality Test



  @PRF-621
  Scenario Outline: Logout AC 1-2-3


    When User is on the login page
    When User logins with "<username>" and "<password>"
    When User clicks the logout button on the right corner of the page
    Then User should be backward to login page
    When User clicks step back button
    Then User shouldn't be able on the dashboard

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |
      | user1           | UserUser123 |

  @PRF-622
    Scenario Outline: Logout AC 4

      When User is on the login page
      When User logins with "<username>" and "<password>"
      When User closes all tabs
      And User opens browser and tries to go dashboard
      Then User shouldn't go to dashboard

    Examples:
      | username        | password    |
      | salesmanager101 | UserUser123 |
      | storemanager51  | UserUser123 |
      | user1           | UserUser123 |

  @PRF-623
    Scenario Outline: User don't use mouse and keyboard
      When User is on the login page
      When User logins with "<username>" and "<password>"
      And User don't use mouse or keyboard for 3 minutes
      Then User should be on to login page

      Examples:
        | username        | password    |
        | salesmanager101 | UserUser123 |
        | storemanager51  | UserUser123 |
        | user1           | UserUser123 |

