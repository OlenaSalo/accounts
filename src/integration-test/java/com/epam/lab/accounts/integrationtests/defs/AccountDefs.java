package com.epam.lab.accounts.integrationtests.defs;

import com.epam.lab.accounts.accounts.AccountsPageController;
import com.epam.lab.accounts.accounts.dto.AccountDTO;
import com.epam.lab.accounts.accounts.facade.AccountFacade;
import com.epam.lab.accounts.accounts.model.AccountModel;
import com.epam.lab.accounts.accounts.model.requests.CreateUpdateAccountRequest;
import com.epam.lab.accounts.accounts.service.AccountService;
import com.epam.lab.accounts.integrationtests.config.CucumberUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AccountDefs {

    @Autowired
    private AccountsPageController accountsPageController;
    @Autowired
    private AccountService accountService;

    @When("^send create-update account request with attributes:$")
    public void sendCreateAccountRequest(final DataTable dataTable) {
        final CreateUpdateAccountRequest request = CucumberUtils.toObject(dataTable, CreateUpdateAccountRequest.class);
        accountsPageController.onCreateAccountRequest(request);
    }

    @Then("^account model exists in database with attributes:$")
    public void accountModelExistsInDatabaseWithAttributes(final DataTable dataTable) {
        final AccountModel expectedAccountModel = CucumberUtils.toObject(dataTable, AccountModel.class);
        final AccountModel actualAccountModel = accountService.getAccountModelForAccountCode(expectedAccountModel.getCode());

        assertEquals(actualAccountModel.getName(), expectedAccountModel.getName());
        assertEquals(actualAccountModel.getUrlToImage(), expectedAccountModel.getUrlToImage());
    }

    @And("user (.+) has (.+) account assigned")
    public void userHasAccountAssigned(final String userEmail, final String accountCode) {
        final List<String> accountsCodes = accountService.getAccountsForUserEmail(userEmail)
                .stream().map(AccountDTO::getCode).collect(Collectors.toList());

        assertThat(accountsCodes, CoreMatchers.hasItem(accountCode));
    }
}
