package com.anz.solution.converter;

import com.anz.solution.entity.Transactions;
import com.anz.solution.model.TransactionDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class TransactionsToTransactionDetailsConverter implements Converter<Transactions, TransactionDetails> {
    @Override
    public TransactionDetails convert(Transactions transactions) {

        TransactionDetails transactionDetails = new TransactionDetails();

        transactionDetails.setAccountNumber(transactions.getAccountNumber());
        transactionDetails.setAccountName(transactions.getAccountName());
        transactionDetails.setTransactionDate(transactions.getTransactionDate());
        transactionDetails.setCurrency(transactions.getCurrency());
        transactionDetails.setDebitAmount(transactions.getDebitAmount());
        transactionDetails.setCreditAmount(transactions.getCreditAmount());
        transactionDetails.setTransactionType(transactions.getTransactionType());
        transactionDetails.setTransactionNarrative(transactions.getTransactionNarrative());

        return transactionDetails;
    }
}
