package com.anz.solution.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String accountNumber;

    private String accountName;

    private Date transactionDate;

    private String currency;

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private String transactionType;

    private String transactionNarrative;

    public Transactions() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionNarrative() {
        return transactionNarrative;
    }
}
