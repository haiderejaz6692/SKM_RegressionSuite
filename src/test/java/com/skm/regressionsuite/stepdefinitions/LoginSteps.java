package com.skm.regressionsuite.stepdefinitions;

import com.skm.regressionsuite.context.ApplicationContext;
import com.skm.regressionsuite.context.FeatureContext;
import com.skm.regressionsuite.context.ScenarioContext;
import com.skm.regressionsuite.pageobjects.LoginPage;
import com.skm.regressionsuite.utils.ConfigLoader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;

import javax.inject.Inject;

public class LoginSteps extends BaseSteps {

	 private LoginPage loginPage;

	
    @Inject
    public LoginSteps(LoginPage loginPage,
    		ApplicationContext applicationContext, ScenarioContext scenarioContext) {
        super(applicationContext, scenarioContext);
        
        this.loginPage = loginPage;
    }
    
    @Given("^User is on the login page$")
    public void user_is_on_login_page() {
        // Assuming the driver was initialized in the ApplicationContext through hooks
    	String baseUrl = ConfigLoader.getProperty("base.url");
    	System.out.println(baseUrl);
        getDriver().get(baseUrl);
    }

    @When("^User enters valid username and password$")
    public void user_enters_valid_credentials() {
    	String usercode = ConfigLoader.getProperty("usercode");
    	String password = ConfigLoader.getProperty("password");
    	this.loginPage.login(usercode, password); 
    	
    }
    
    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_valid_credentials(String username, String password) {
        // Use the captured username and password from the feature file
        loginPage.login(username, password);
    }
    
    @When("^User enters username \"([^\"]*)\"$")
    public void user_enters_username(String username) {
        
        loginPage.enterUsername(username);
    }

    @Then("^The User Full Name should be Visible as \"([^\"]*)\"$")
    public void user_full_name_visibility(String expectedUserFullName) {
    	String actualFullName = loginPage.getUserFullName();
    	Assertions.assertThat(actualFullName).isEqualToIgnoringCase(expectedUserFullName);
    }

    @Then("^User should be redirected to the home page$")
    public void user_is_redirected_to_homepage() {

        String currentUrl = getDriver().getCurrentUrl();
        Assertions.assertThat(currentUrl).contains(ConfigLoader.getProperty("homepage"));
    }
}
