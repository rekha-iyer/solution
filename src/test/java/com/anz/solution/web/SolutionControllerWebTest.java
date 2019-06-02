package com.anz.solution.web;

import com.anz.solution.entity.Accounts;
import com.anz.solution.entity.Transactions;
import com.anz.solution.repository.AccountsRepository;
import com.anz.solution.repository.TransactionsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SolutionControllerWebTest {

    @MockBean
    private AccountsRepository accountsRepository;

    @MockBean
    private TransactionsRepository transactionsRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testFindAccountsSingleAccount() throws Exception {
        final String userId = "1";

        List<Accounts> accountsList = Collections.singletonList(buildAccount("585309209"));

        when(accountsRepository.findAccountsByUserId(userId)).thenReturn(accountsList);

        String expectedJsonContent = readFile("/samples/accounts_single.json");

        mockMvc.perform(get("/user/1/accounts")).andExpect(status().isOk()).andExpect(content().json(expectedJsonContent, false));
    }

    @Test
    public void testFindAccountsNoAccount() throws Exception {
        final String userId = "1";

        List<Accounts> accountsList = Collections.emptyList();

        when(accountsRepository.findAccountsByUserId(userId)).thenReturn(accountsList);

        String expectedJsonContent = readFile("/samples/accounts_empty.json");

        mockMvc.perform(get("/user/1/accounts")).andExpect(status().isOk()).andExpect(content().json(expectedJsonContent, false));
    }

    @Test
    public void testFindTransactionsMultipleTransactions() throws Exception {
        final String accountId = "585309209";

        List<Transactions> transactionsList = Arrays.asList(buildTransactions("791066619", new BigDecimal("3.142")), buildTransactions("791066619", new BigDecimal("2.17")));

        when(transactionsRepository.findTransactionsByAccountNumber(accountId)).thenReturn(transactionsList);

        String expectedJsonContent = readFile("/samples/transactions_multiple.json");

        mockMvc.perform(get("/user/1/accounts/585309209/transactions")).andExpect(status().isOk()).andExpect(content().json(expectedJsonContent, false));
    }

    @Test
    public void testFindTransactionsNoTransactions() throws Exception {
        final String accountId = "585309209";

        List<Transactions> transactionsList = Collections.emptyList();

        when(transactionsRepository.findTransactionsByAccountNumber(accountId)).thenReturn(transactionsList);

        String expectedJsonContent = readFile("/samples/transactions_empty.json");

        mockMvc.perform(get("/user/1/accounts/585309209/transactions")).andExpect(status().isOk()).andExpect(content().json(expectedJsonContent, false));
    }

    @Test
    public void testErrorFromDB() throws Exception {
        final String accountId = "585309209";
        when(transactionsRepository.findTransactionsByAccountNumber(accountId)).thenThrow(new RuntimeException("Error While connecting to DB"));

        String expectedJsonContent = readFile("/samples/error_response.json");

        mockMvc.perform(get("/user/1/accounts/585309209/transactions")).andExpect(status().isInternalServerError()).andExpect(content().json(expectedJsonContent, false));
    }

    private Transactions buildTransactions(String accountNumber, BigDecimal creditAmount) {
        Transactions transactions = new Transactions();
        transactions.setAccountName("AUSavings933");
        transactions.setAccountNumber(accountNumber);
        transactions.setCreditAmount(creditAmount);
        transactions.setCurrency("AUD");

        return transactions;
    }

    private Accounts buildAccount(String accountNumber) {
        Accounts accounts = new Accounts();
        accounts.setAccountName("SGSavings729");
        accounts.setAccountNumber(accountNumber);
        accounts.setAccountType("Savings");
        accounts.setCurrency("AUD");

        return accounts;
    }

    public String readFile(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(this.getClass().getResource(fileName).toURI())), "UTF8");
    }
}
