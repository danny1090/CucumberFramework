Feature: Job Title
@db
  Scenario Outline: Job Title verification
  
    Given I logged into OrangeHrm
    And I click on the Admin link
    And I click on the Job link
    When I click on Job Titles
    And I get all Job Titles from UI
    And I execute “<SqlQuery>” from Database
    Then Job titles are matched

    Examples: 
      | SqlQuery                              |
      | SELECT JOB_TITLE FROM JOBS ORDER BY 1 |
