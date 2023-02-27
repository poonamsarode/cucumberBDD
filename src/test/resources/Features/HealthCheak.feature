@ui @healthCheak

Feature:  E-commerce Project Web Site Health Check

 Scenario: User is able to Open the application and able to perform search opeartion
  Given User opened browser
  And User navigated to the landing page of application 
  When User Search for product "Laptop"
  Then Search Result page is displayed

