package com.epam.lab.accounts.e2e.defs;

import com.epam.lab.accounts.accounts.facade.AccountFacade;
import com.epam.lab.accounts.accounts.model.requests.UserLoginRequest;
import com.epam.lab.accounts.accounts.model.requests.UserRegistrationRequest;
import com.epam.lab.accounts.accounts.service.AccountService;
import com.epam.lab.accounts.e2e.config.PageDriver;
import com.epam.lab.accounts.integrationtests.config.CucumberUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.TestCase.assertTrue;

public class UserDefs {
    @Autowired
    private PageDriver pageDriver;
    @Autowired
    private AccountFacade accountFacade;
    @Autowired
    private AccountService accountService;

    @When("user submit login form with attributes:")
    public void userSubmitLoginFormWithAttributes(final DataTable dataTable) {
        final UserLoginRequest userLoginRequest = CucumberUtils.toObject(dataTable, UserLoginRequest.class);
        pageDriver.findOne(By.id("login.email")).sendKeys(userLoginRequest.getEmail());
        pageDriver.findOne(By.id("login.password")).sendKeys(userLoginRequest.getPassword());
        pageDriver.findOne(By.id("login.submit")).submit();
    }

    @Then("user is logged in and located on home page")
    public void userIsLoggedInAndLocatedOnHomePage() {
        assertTrue(pageDriver.isElementExists(By.id("home.user.menu")));
    }

    @When("user submit registration form with attributes:")
    public void userSubmitRegistrationFormWithAttributes(final DataTable dataTable) {
        final UserRegistrationRequest request = CucumberUtils.toObject(dataTable, UserRegistrationRequest.class);
        pageDriver.findOne(By.id("register.firstName")).sendKeys(request.getFirstName());
        pageDriver.findOne(By.id("register.lastName")).sendKeys(request.getLastName());
        pageDriver.findOne(By.id("register.email")).sendKeys(request.getEmail());
        pageDriver.findOne(By.id("register.password")).sendKeys(request.getPassword());
        pageDriver.findOne(By.id("register.submit")).click();
    }
}
