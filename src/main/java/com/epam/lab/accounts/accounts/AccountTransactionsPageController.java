package com.epam.lab.accounts.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountTransactionsPageController {

    public static final String ACCOUNTS_TRANSACTIONS_JSP = "accounts-transactions";

    @RequestMapping("/accounts/{accountCode}/transactions")
    public String onGetAccountTransactionsPage(@PathVariable String accountCode) {

        return ACCOUNTS_TRANSACTIONS_JSP;
    }
}
