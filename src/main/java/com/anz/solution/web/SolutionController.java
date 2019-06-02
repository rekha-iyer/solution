package com.anz.solution.web;

import com.anz.solution.model.AccountDetails;
import com.anz.solution.model.TransactionDetails;
import com.anz.solution.model.UserTransactionDetails;
import com.anz.solution.service.SolutionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SolutionController {

    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    private final SolutionService solutionService;

    private AccountsAssembler accountsAssembler;

    private UserTransactionDetailsAssembler userTransactionDetailsAssembler;

    public SolutionController(SolutionService solutionService,
                              AccountsAssembler accountsAssembler,
                              UserTransactionDetailsAssembler userTransactionDetailsAssembler) {
        this.solutionService = solutionService;
        this.accountsAssembler = accountsAssembler;
        this.userTransactionDetailsAssembler = userTransactionDetailsAssembler;
    }

    @RequestMapping(method = GET, value = "/user/{user}/accounts", produces = HAL_MEDIA_TYPE)
    @ResponseStatus(OK)
    public List<AccountsResource> findAccounts(@PathVariable final String user) {

        List<AccountDetails> accountsList = solutionService.findAccounts(user);
        return accountsAssembler.toResources(accountsList);
    }

    @RequestMapping(method = GET, value = "/user/{user}/accounts/{account}/transactions", produces = HAL_MEDIA_TYPE)
    @ResponseStatus(OK)
    public UserTransactionDetailsResource findTransactions(@PathVariable final String user,
                                                       @PathVariable final String account) {
        List<TransactionDetails> transactionsList = solutionService.findTransactions(account);

        UserTransactionDetails userTransactionDetails = new UserTransactionDetails();
        userTransactionDetails.setUserId(user);
        userTransactionDetails.setTransactionDetailsList(transactionsList);

        return userTransactionDetailsAssembler.toResource(userTransactionDetails);
    }

}
