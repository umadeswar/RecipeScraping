
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Recipe Scrapping
    Given User lauches the  chrome browser 
   
    When User opens  URL "www.tarladalal.com"
    And type "Health" in search box
    And clicks "search" button
    And User clicks the first recipe link
    Then the data is stored in excel
    And close browser
   

 #Scenario: Scrape into excel
  #  Given user is in Health Page
   
   # When User clicks the first recipe link
   
    #Then the data is stored in excel
 