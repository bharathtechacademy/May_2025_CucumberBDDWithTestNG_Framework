Feature: Github API Load Testing
  I want to use this feature file to validate all scenarios related to load testing.

  @Regression
  Scenario: Request to verify the performance testing of GitHub APIs
    When The User load the Jmeter file "GitHub_API_LoadTest.jmx"
    Then The User should be able to run the JMeter file
