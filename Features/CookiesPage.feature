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

  @Sanity
  Scenario: Verify the cookies pop-up is displayed within the login page
    Given Launch the application
    Then Verify cookies pop-up is displayed

  @Sanity
  Scenario: Verify the cookies pop-up content message
    Given Launch the application
    Then Verify cookies pop-up is displayed
    And verify cookies pop-up <content>.
      | content                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | We may use cookies and similar technologies to collect information about the ways you interact with and use the website, to support and enhance features and functionality, to monitor performance, to personalize content and experiences, for marketing and analytics, and for other lawful purposes. We also may share information about your use of our site with our social media, advertising and analytics partners who may combine it with other information that you�ve provided to them or that they�ve collected from your use of their services. Please, see more details on the "About" tab |

  @Sanity
  Scenario: Verify Cookies pop-up logos
    Given Launch the application
    Then Verify cookies pop-up is displayed
    And verify Cookies Popup Logos

  @Sanity
  Scenario: Verify Cookies pop-up popup button
    Given Launch the application
    Then Verify cookies pop-up is displayed
    And verify Cookies Popup buttons are displayed

  @Sanity
  Scenario: Verify Cookies pop-up switch buttons
    Given Launch the application
    Then Verify cookies pop-up is displayed
    And verify Cookies Popup switch buttons are displayed
    And verify that the necessary switch button is disabled

  @Sanity
  Scenario: Verify Cookies pop-up show details link.
    Given Launch the application
    Then Verify cookies pop-up is displayed
    When user clicks on the Show details link
    Then cookies pop-up should be displayed in expanded view

  @Sanity
  Scenario: Verify Cookies pop-up when a user accepts the cookies
    Given Launch the application
    Then Verify cookies pop-up is displayed
    When user selects the option to "Allow All"
    Then the cookies popup should be closed
