@ui @healthCheak

Feature:  E-commerce Project Web Site Health Check

@Search
 Scenario: User is able to Open the application and able to perform search opeartion
 # Given User opened browser
   Given User navigated to the landing page of application 
   When User Search for product "fridge"
   Then Search Result page is displayed
 # And browser is closed

@Search
Scenario: User is able to Open the application and able to perform search opeartion
 # Given User opened browser
   Given User navigated to the landing page of application 
   When User Search for product "mobiles"
   Then Search Result page is displayed
 # And browser is closed

#  Scenario: User is able to Open the application and able to perform search opeartion
# Given User opened browser
# And User navigated to the landing page of application 
# When User Search for product "fridge"
# Then Search Result page is displayed
# And browser is closed
  
#  Scenario: User is able to Open the application and able to perform search opeartion
#  Given User opened browser
#  And User navigated to the landing page of application 
#  When User Search for product "tablets"
#  Then Search Result page is displayed
#  And browser is closed
  
  @prodDesc
   Scenario: User is click on the Product and check the Product Details
#   Given User opened browser
    Given User navigated to the landing page of application 
    And User Search for product "Laptop"
    When User click on any product
    Then Product Description is displayed in new tab
#   And browser is closed
  
  