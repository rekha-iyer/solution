package com.anz.solution.service;

import com.anz.solution.convertor.AccountsToAccountDetailsConverter;
import com.anz.solution.convertor.TransactionsToTransactionDetailsConverter;
import com.anz.solution.entity.Accounts;
import com.anz.solution.entity.Transactions;
import com.anz.solution.model.AccountDetails;
import com.anz.solution.model.TransactionDetails;
import com.anz.solution.repository.AccountsRepository;
import com.anz.solution.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionService {

    private final AccountsRepository accountsRepository;

    private final TransactionsRepository transactionsRepository;

    private final AccountsToAccountDetailsConverter accountsToAccountDetailsConverter;

    private final TransactionsToTransactionDetailsConverter transactionsToTransactionDetailsConverter;

    @Autowired
    public SolutionService(AccountsRepository accountsRepository,
                           TransactionsRepository transactionsRepository,
                           AccountsToAccountDetailsConverter accountsToAccountDetailsConverter,
                           TransactionsToTransactionDetailsConverter transactionsToTransactionDetailsConverter) {
        this.accountsRepository = accountsRepository;
        this.transactionsRepository = transactionsRepository;
        this.accountsToAccountDetailsConverter = accountsToAccountDetailsConverter;
        this.transactionsToTransactionDetailsConverter = transactionsToTransactionDetailsConverter;
    }

    public List<AccountDetails> findAccounts(String userId) {
        List<Accounts> accountsList = accountsRepository.findAccountsByUserId(userId);

        List<AccountDetails> accountDetailsList = accountsList.stream()
                .map(account -> accountsToAccountDetailsConverter.convert(account)).collect(Collectors.toList());

        return accountDetailsList;
    }

    public List<TransactionDetails> findTransactions(String account) {
        List<Transactions> transactionsList = transactionsRepository.findTransactionsByAccountNumber(account);

        List<TransactionDetails> transactionDetailsList = transactionsList.stream()
                .map(transaction -> transactionsToTransactionDetailsConverter.convert(transaction)).collect(Collectors.toList());

        return transactionDetailsList;
    }
}
