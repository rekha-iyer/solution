package com.anz.solution.web;

import com.anz.solution.model.UserTransactionDetails;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class UserTransactionDetailsAssembler extends ResourceAssemblerSupport<UserTransactionDetails, UserTransactionDetailsResource> {
    public UserTransactionDetailsAssembler() {
        super(SolutionController.class, UserTransactionDetailsResource.class);
    }

    @Override
    public UserTransactionDetailsResource toResource(UserTransactionDetails userTransactionDetails) {

        UserTransactionDetailsResource resource = new UserTransactionDetailsResource(userTransactionDetails);

        resource.add(linkTo(methodOn(SolutionController.class).findAccounts(userTransactionDetails.getUserId())).withRel("user-accounts"));

        return resource;
    }
}
