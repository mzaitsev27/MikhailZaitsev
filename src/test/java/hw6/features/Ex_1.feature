Feature: Ex_1_feature

  Scenario: Ex_1_scenario
    Given I open EPAM JDI Site
    When I login as user 'epam' with password '1234' on the Home page
    Then username should be 'PITER CHAILOVSKII' on the Home page
    And 4 images should be displayed
    And 4 texts under pictures should be displayed
    And main header should be displayed
    And main header text should be displayed
    When I click on Service subcategory in the header
    Then Service dropdown should contain options
      | SUPPORT            |
      | DATES              |
      | SEARCH             |
      | COMPLEX TABLE      |
      | SIMPLE TABLE       |
      | USER TABLE         |
      | TABLE WITH PAGES   |
      | DIFFERENT ELEMENTS |
      | PERFORMANCE        |
    When I click on Service subcategory in the left section
    Then Service dropdown should contain options in the left section
      | Support            |
      | Dates              |
      | Complex Table      |
      | Simple Table       |
      | Search             |
      | User Table         |
      | Table with pages   |
      | Different elements |
      | Performance        |
    Given I click on 'DIFFERENT ELEMENTS' option in the header
    Then 4 Checkboxes should be displayed
    Then 4 radios should be displayed
    Then 2 buttons should be displayed
    Then 1 dropdown should be displayed
    Then Right section should be displayed
    Then Left section should be displayed
    When I select Water and Wind checkboxes
    Then Logs are displayed , checkbox name corresponding to selected
    When I select Selen radio
    Then Logs are displayed , radio name corresponding to selected
    When I select Yellow in dropdown
    Then Logs are displayed , color name corresponding to selected
    When I unselect Water and Wind checkboxes
    Then Logs are displayed , checkbox name corresponding to selected


