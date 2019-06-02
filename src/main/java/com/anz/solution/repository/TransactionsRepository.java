package com.anz.solution.repository;

import com.anz.solution.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, String>, JpaSpecificationExecutor<Transactions> {
    List<Transactions> findTransactionsByAccountNumber(String accountNumber);
}
