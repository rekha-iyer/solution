package com.anz.solution.web;

import com.anz.solution.model.TransactionDetails;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class TransactionsResource extends Resource<TransactionDetails> {
    public TransactionsResource(TransactionDetails content, Link... links) {
        super(content, links);
    }

    public TransactionsResource(TransactionDetails content, Iterable<Link> links) {
        super(content, links);
    }
}
