package com.anz.solution.model;

import java.util.List;
import java.util.Objects;

public class UserTransactionDetails {

    private String userId;
    private List<TransactionDetails> transactionDetailsList;

    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTransactionDetails that = (UserTransactionDetails) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(transactionDetailsList, that.transactionDetailsList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, transactionDetailsList);
    }
}
