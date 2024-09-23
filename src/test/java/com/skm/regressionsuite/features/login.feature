Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    Then User should be redirected to the home page

 	Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "00160000004974" and password "123456789"
    Then User should be redirected to the home page
    
	Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "00160000004974"
    Then The User Full Name should be Visible as "00160000004974 Devdb"