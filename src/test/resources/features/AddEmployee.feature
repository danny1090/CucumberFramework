#Author: Danny Cabrera
Feature: Add Employee

  Background: 
    Given I logged into OrangeHrm successfully
    And I click on PIM link
    And I click on Add Employee link

  @smoke @addEmployee
  Scenario Outline: Add Epmloyee
    When I provide "<FirstName>", "<MiddleName>", "<LastName>" and "<Location>"
    And I click on save button
    Then I see "<FirstName>", "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName | Location     |
      | Jane      | J          | Smith    | Smart Office |
      | James     | A          | West     | Tech Office  |
      | Jackie    | E          | Ella     | HQ           |

  Scenario: Add Employee and Create Login Details
    When I provide firstname, middlename, lastname and location
    And I click on create login details
    And I provide all mandatory fields
    And I click on save button

  @temp
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Names          |
      | Middle Name          |
      | Last Name            |
      | Employee id          |
      | Location             |
      | Create Login Details |
