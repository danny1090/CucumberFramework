#Author: syntax team   or jonsmith@wellsfargo.com
@sprint3
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @jenkins
  Scenario: Valid login
    Given I navigate to OrangeHrm
    When I enter a valid username and password
    And I click the login button
    Then I successfully logged in

  @regression 
  Scenario: Invalid login
    Given I navigate to OrangeHrm
    When I enter a invalid username and password
    And I click the login button
    Then I see error message is displayed

  
  Scenario: Error message Validation
    When I enter a invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Admin    | Syntax123! | errorMessage        |
