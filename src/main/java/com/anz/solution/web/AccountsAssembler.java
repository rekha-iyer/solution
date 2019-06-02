package com.anz.solution.web;

import com.anz.solution.model.AccountDetails;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class AccountsAssembler extends ResourceAssemblerSupport<AccountDetails, AccountsResource> {
    public AccountsAssembler() {
        super(SolutionController.class, AccountsResource.class);
    }

    @Override
    public AccountsResource toResource(AccountDetails accountDetails) {

        AccountsResource resource = new AccountsResource(accountDetails);

        resource.add(linkTo(methodOn(SolutionController.class)
                .findAccounts(accountDetails.getUserId())).withSelfRel());

        return resource;
    }
}
