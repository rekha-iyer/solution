package com.anz.solution.repository;

import com.anz.solution.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Accounts, String>, JpaSpecificationExecutor<Accounts> {
    List<Accounts> findAccountsByUserId(String userId);
}
