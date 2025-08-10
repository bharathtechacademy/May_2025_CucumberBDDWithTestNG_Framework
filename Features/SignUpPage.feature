#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Cookies feature in Creatio CRM
  I want to use this feature file to verify all the test scenarios related to the cookies page.
  
   Background: Initialize all pages
    Given Initialize page objects

  @Regression
  Scenario Outline: Verify Sign Up Feature
    Given Launch the application
    Then Verify cookies popup is displayed successfully
    When user selects the option to "Allow All"
    Then the cookies popup should be closed
    When User click on the SignUp link
    Then SignUp page should be launched
    When User entered <Username> and <Password>
    And Click on Continue button
    And Enter Company Details
    And Click on SignUp button
    Then SignUp should be successful

    Examples: 
      | Username                     | Password                 |
      | Bharattechacademy2@gmail.com | Bharattechacademy2@gmail |
