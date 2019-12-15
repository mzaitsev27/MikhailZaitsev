Feature: Ex_2_feature

  Scenario: Ex_2_scenario
    Given I am on Home Page
    And I login as user Piter Chailovskii
    And I click on 'USER TABLE' button in Service dropdown
    Then 'User Table' page is opened
    And 6 NumberType Dropdowns should be displayed
    And 6 User names should be displayed
    And 6 Description images should be displayed
    And 6 Description texts under images should be displayed
    And 6 checkboxes should be displayed
    And User table contains following values:
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
    When I click on dropdown in column Type for user 'Roman'
    Then droplist contains values
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |
