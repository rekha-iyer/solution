package com.anz.solution.web;

import com.anz.solution.model.AccountDetails;
import com.anz.solution.model.TransactionDetails;
import com.anz.solution.model.UserTransactionDetails;
import com.anz.solution.service.SolutionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = "/user/{user}/accounts", produces = HAL_MEDIA_TYPE)
    @ApiOperation("Get accounts for a user")
    public List<AccountsResource> findAccounts(@PathVariable final String user) {

        List<AccountDetails> accountsList = solutionService.findAccounts(user);
        return accountsAssembler.toResources(accountsList);
    }


    @GetMapping(value = "/user/{user}/accounts/{account}/transactions", produces = HAL_MEDIA_TYPE)
    @ApiOperation("Get transaction for an account")
    public UserTransactionDetailsResource findTransactions(@PathVariable final String user,
                                                       @PathVariable final String account) {
        List<TransactionDetails> transactionsList = solutionService.findTransactions(account);

        UserTransactionDetails userTransactionDetails = new UserTransactionDetails();
        userTransactionDetails.setUserId(user);
        userTransactionDetails.setTransactionDetailsList(transactionsList);

        return userTransactionDetailsAssembler.toResource(userTransactionDetails);
    }

}
