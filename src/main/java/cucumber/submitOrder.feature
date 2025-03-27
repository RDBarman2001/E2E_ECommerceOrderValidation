
@tag
Feature: Purchase the order from Ecommerce Website

Background:
Given I landed on Ecommerce page
  @tag1
  Scenario Outline: Positive test of submitting the order 
    Given Logged in with <username> and <password>
    And I add <product> into cart
    And Checkout <product> and submit the order
    Then "Thankyou for the order." message is displayed on corformationPage
  


    Examples: 
      |username|password|product|
      |shetty@gmail.com|Iamking@000|ADIDAS ORIGINAL|
      
