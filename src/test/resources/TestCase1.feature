
Feature: Verification

Background:
  User navigates to website Given
  I am on site registration page

  Scenario: Verification
  Given I am on website
  When I verify the title of the page
  When I click on Mobile Menu
  Then I verify the title of the page
  When I select the 'SORT BY' dropdown by name
  Then products are sorted by name