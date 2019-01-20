package com.epam.lab.accounts.e2e.defs;

import com.epam.lab.accounts.accounts.model.requests.CreateUpdateAccountRequest;
import com.epam.lab.accounts.e2e.config.PageDriver;
import com.epam.lab.accounts.integrationtests.config.CucumberUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.junit.Assert.*;

public class AccountE2eDefs {

    @Autowired
    private PageDriver pageDriver;

    @Given("^user submit create-update account form with attributes:$")
    public void userSubmitCreateUpdateAccountForm(final DataTable dataTable) throws InterruptedException {
        final CreateUpdateAccountRequest request = CucumberUtils.toObject(dataTable, CreateUpdateAccountRequest.class);
        if (!isBlank(request.getAccountCode())) {
            pageDriver.findOne(By.id("account.edit.code")).sendKeys(request.getAccountCode());
        }
        pageDriver.findOne(By.id("account.edit.name")).sendKeys(request.getAccountName());
        pageDriver.findOne(By.id("imgUrl")).sendKeys(request.getAccountImage());
        pageDriver.findOne(By.id("account.edit.submit")).submit();
    }

    @Then("account details displayed on accounts grid page")
    public void accountOnAccountsGridPage(final DataTable dataTable) {
        final CreateUpdateAccountRequest request = CucumberUtils.toObject(dataTable, CreateUpdateAccountRequest.class);

        assertTrue(pageDriver.isElementExists(By.id("home.accounts." + request.getAccountCode())));
        assertEquals(
                pageDriver.findOne(By.id("home.accounts." + request.getAccountCode() + ".name")).getText(),
                CucumberUtils.toObject(dataTable, CreateUpdateAccountRequest.class).getAccountName());
    }
}
