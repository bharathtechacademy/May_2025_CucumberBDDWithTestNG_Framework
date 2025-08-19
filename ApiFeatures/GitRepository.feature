Feature: Github Repository related Scenarios
  I want to use this feature file to verify all the scenarios related to GitHub repository.

  @Regression
  Scenario: Request to create a Inavlid repository for the authenticated user.
    Given User sets the repository name as "" and description as "Sample Repository Description"
    When User sends a "POST" request to "/user/repos" To create the repository with visibility "true"
    Then User should get the response code as 422
    And User should get the response message as "Unprocessable Entity"
    And The response time should be less than 2 seconds
    And The response body should have "message" as "New repository name must not be blank"

  @Regression
  Scenario: Request to create a Valid repository for the authenticated user.
    Given User sets the repository name as "SampleRepoFromRestAssured" and description as "Sample Repository Description"
    When User sends a "POST" request to "/user/repos" To create the repository with visibility "true"
    Then User should get the response code as 201
    And User should get the response message as "Created"
    And The response time should be less than 2 seconds
    And The response body should have "name" as "SampleRepoFromRestAssured"

  @Regression
  Scenario: Request to get a Valid repository for the authenticated user.
    When User sends a "GET" request to "/repos/bharathtechacademy05/SampleRepoFromRestAssured" to get the repository
    Then User should get the response code as 200
    And User should get the response message as "OK"
    And The response time should be less than 2 seconds
    And The response body should have "name" as "SampleRepoFromRestAssured"
    And The response body should have "description" as "Sample Repository Description"

  @Regression
  Scenario: Request to update a Valid repository for the authenticated user.
    When User sends a "PATCH" request to "/repos/bharathtechacademy05/SampleRepoFromRestAssured" to update repository visibility "false"
    Then User should get the response code as 200
    And User should get the response message as "OK"
    And The response time should be less than 2 seconds
    And The response body should have "name" as "SampleRepoFromRestAssured"
    And The response body should have "description" as "Sample Repository Description"
    And The response body should have "private" as "false"

  @Regression
  Scenario: Request to delete a Valid repository for the authenticated user.
    When User sends a "DELETE" request to "/repos/bharathtechacademy05/SampleRepoFromRestAssured" to get the repository
    Then User should get the response code as 204
    And User should get the response message as "No Content"
    And The response time should be less than 2 seconds
