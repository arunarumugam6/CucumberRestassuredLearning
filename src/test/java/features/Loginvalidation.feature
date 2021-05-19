Feature: Test Add and Delete place of google map
# Kirubakaran first commit today
	@AddPlace
	Scenario: Test Add Place
	    Given Trigger the "LoginAPI" with "POST" method with Username and Password 
	    Then Validate the status code 400 in the response
	    And validate the error response message "Missing email or username" in the response
	    
	    