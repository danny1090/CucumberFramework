Feature:Google search
Scenario: search by voice
Given i navigate to google
When i click microphone icon
And i speak search item
Then i see search results of search displayed
And i see number of search results


