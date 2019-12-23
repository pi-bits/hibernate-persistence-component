Ability: As a user I want to save or update or get test scenarios

 Scenario: As a user I should save scenario details
   Given I have new id
   And I have task description as GOVERNANCE
   And I have data for the scenario
   When I save scenario data
   Then I should see 'status' as READY
   And I should see 'task description' as GOVERNANCE

 Scenario: As a user I should update scenario details
   Given I have existing id
   And I have task description as COMPLETION
   And I have data for the scenario
   And I have the status as IN_PROGRESS
   When I update scenario data
   And I should see 'status' as READY
   And I should see 'task description' as COMPLETION

 Scenario: As a user I should get the scenario ready for execution
   Given I have existing id
   And I have task description as COMPLETION
   And I have data for the scenario
   And I have the status as READY
   When I get scenario data
   And I should see 'status' as READY
   And I should see 'task description' as COMPLETION