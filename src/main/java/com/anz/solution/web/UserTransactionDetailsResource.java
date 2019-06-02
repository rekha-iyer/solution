package com.anz.solution.web;

import com.anz.solution.model.UserTransactionDetails;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class UserTransactionDetailsResource extends Resource<UserTransactionDetails> {
    public UserTransactionDetailsResource(UserTransactionDetails content, Link... links) {
        super(content, links);
    }

    public UserTransactionDetailsResource(UserTransactionDetails content, Iterable<Link> links) {
        super(content, links);
    }
}