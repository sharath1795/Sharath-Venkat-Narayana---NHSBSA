@jobsearch
Feature: NHS Job Seach Functionality

  @jobsearch @smoke @chrome
  Scenario: Verify that job search results are sorted by Date Posted
    Given Chrome browser is launched
    And I visit the NHS Jobs website
    And Search page is loaded
    When I enter Job Title and Location and Distance information
    And Search button is clicked
    Then Search Results are displayed
    And The Results are sorted by Date Posted
    
  @jobsearch @smoke @firefox
  Scenario: Verify that job search results are sorted by Date Posted
    Given Firefox browser is launched
    And I visit the NHS Jobs website
    And Search page is loaded
    When I enter Job Title and Location and Distance information
    And Search button is clicked
    Then Search Results are displayed
    And The Results are sorted by Date Posted

  #@jobsearchwithExamples
  #Scenario Outline: Verify that job search results are sorted by Date Posted
    #Given I visit the NHS Jobs website
    #And Search page is loaded
    #When I enter "<Job Title>" and "<Location>" and "<Distance>" information
    #And Search button is clicked
    #Then Search Results are displayed
    #And The Results are sorted by Date Posted
    #Examples: 
     	#| Job Title  | Location | Distance  |
      #| Software Developer |	London	| +50 Miles |
      #| Business Analyst |	Birmingham	| +30 Miles	|