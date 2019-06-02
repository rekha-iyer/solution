package com.anz.solution.web;

import com.anz.solution.model.AccountDetails;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class AccountsResource extends Resource<AccountDetails> {
    public AccountsResource(AccountDetails content, Link... links) {
        super(content, links);
    }

    public AccountsResource(AccountDetails content, Iterable<Link> links) {
        super(content, links);
    }
}
