#Author: prasad

@tag
Feature: Nestle automation scenarios

Scenario: User creates a new account successfully
    Given the user is on the registration page
    When the user enters valid details
      |	Email										| FirstName | LastName | Phone  		|	PractitionerType	|	License	|	Personal use								|	Address1					|	City				|	State			|	Zip					|	Referral			|
      |automation1234@gmail.com | John      | Doe      | 9000900090 |	Dentistry					|	abc123	|	For personal or family use	|	99 UNIVERSITY AVE	|	NEW CASTLE	|	Delaware	|	19720-4319	|	Catalog Mail	|
    And clicks on the register button
    Then the account should be created successfully
