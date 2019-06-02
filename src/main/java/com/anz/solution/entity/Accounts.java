package com.anz.solution.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String userId;

    private String accountNumber;

    private String accountName;

    private String accountType;

    private Date balanceDate;

    private String currency;

    private BigDecimal openingAvailableBalance;

    public Accounts() {
    }

    public String getUserId() {
        return userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getOpeningAvailableBalance() {
        return openingAvailableBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(id, accounts.id) &&
                Objects.equals(userId, accounts.userId) &&
                Objects.equals(accountNumber, accounts.accountNumber) &&
                Objects.equals(accountName, accounts.accountName) &&
                Objects.equals(accountType, accounts.accountType) &&
                Objects.equals(balanceDate, accounts.balanceDate) &&
                Objects.equals(currency, accounts.currency) &&
                Objects.equals(openingAvailableBalance, accounts.openingAvailableBalance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, accountNumber, accountName, accountType, balanceDate, currency, openingAvailableBalance);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency='" + currency + '\'' +
                ", openingAvailableBalance=" + openingAvailableBalance +
                '}';
    }
}
