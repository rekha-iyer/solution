package com.anz.solution.converter;

import com.anz.solution.entity.Accounts;
import com.anz.solution.model.AccountDetails;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class AccountsToAccountDetailsConverter implements Converter<Accounts, AccountDetails> {
    @Override
    public AccountDetails convert(Accounts accounts) {
        AccountDetails accountDetails = new AccountDetails();

        accountDetails.setUserId(accounts.getUserId());
        accountDetails.setAccountNumber(accounts.getAccountNumber());
        accountDetails.setAccountName(accounts.getAccountName());
        accountDetails.setAccountType(accounts.getAccountType());
        accountDetails.setBalanceDate(accounts.getBalanceDate());
        accountDetails.setCurrency(accounts.getCurrency());
        accountDetails.setOpeningAvailableBalance(accounts.getOpeningAvailableBalance());

        return accountDetails;
    }
}
