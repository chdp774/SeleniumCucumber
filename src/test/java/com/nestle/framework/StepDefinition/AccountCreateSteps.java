package com.nestle.framework.StepDefinition;

import com.nestle.framework.Factory.DriverFactory;
import com.nestle.framework.PageObjects.M2FE_AccountCreation_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreateSteps {
	
	private M2FE_AccountCreation_Page account_page = new M2FE_AccountCreation_Page(DriverFactory.getDriver());
	@Given("the user is on the registration page")
	public void the_user_is_on_the_registration_page() {
	   account_page.accountCreation("prasad@gmail.com", "prasad", "automation", "9000900090", "Dentistry", "ax98097", 
			   "For personal or family use", "99 UNIVERSITY AVE", "NEW CASTLE", "Delaware", "19520-4319", "Catalog Mail");
	}

	@When("the user enters valid details")
	public void the_user_enters_valid_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("test1");
	}

	@When("clicks on the register button")
	public void clicks_on_the_register_button() {
		System.out.println("test1");
	}

	@Then("the account should be created successfully")
	public void the_account_should_be_created_successfully() {
		System.out.println("test1");
	}
}
