package com.anz.solution.web;

import com.anz.solution.model.TransactionDetails;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class TransactionsAssembler  extends ResourceAssemblerSupport<TransactionDetails, TransactionsResource> {
    public TransactionsAssembler() {
        super(SolutionController.class, TransactionsResource.class);
    }

    @Override
    public TransactionsResource toResource(TransactionDetails transactionDetails) {

        TransactionsResource resource = new TransactionsResource(transactionDetails);

        resource.add(linkTo(methodOn(SolutionController.class)
                .findTransactions(transactionDetails.getAccountNumber())).withSelfRel());

        return resource;
    }
}