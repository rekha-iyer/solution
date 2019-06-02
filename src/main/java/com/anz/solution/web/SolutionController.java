package com.anz.solution.web;

import com.anz.solution.entity.Accounts;
import com.anz.solution.entity.Transactions;
import com.anz.solution.model.AccountDetails;
import com.anz.solution.model.TransactionDetails;
import com.anz.solution.service.SolutionService;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class SolutionController {

    private static final String HAL_MEDIA_TYPE = "application/hal+json";

    private final SolutionService solutionService;

    private AccountsAssembler accountsAssembler;

    private TransactionsAssembler transactionsAssembler;

    public SolutionController(SolutionService solutionService,
                              AccountsAssembler accountsAssembler,
                              TransactionsAssembler transactionsAssembler) {
        this.solutionService = solutionService;
        this.accountsAssembler = accountsAssembler;
        this.transactionsAssembler = transactionsAssembler;
    }

    @RequestMapping(method = GET, value = "/user/{user}/accounts", produces = HAL_MEDIA_TYPE)
    @ResponseStatus(OK)
    public List<AccountsResource> findAccounts(@PathVariable final String user) {

        List<AccountDetails> accountsList = solutionService.findAccounts(user);
        Link selfLink = linkTo(methodOn(SolutionController.class)
                .findAccounts(user))
                .withSelfRel();
        return accountsAssembler.toResources(accountsList);
    }

    @RequestMapping(method = GET, value = "/accounts/{account}/transactions", produces = HAL_MEDIA_TYPE)
    @ResponseStatus(OK)
    public List<TransactionsResource> findTransactions(@PathVariable final String account) {
        List<TransactionDetails> transactionsList = solutionService.findTransactions(account);
        return transactionsAssembler.toResources(transactionsList);
    }

}
