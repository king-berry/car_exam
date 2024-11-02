package com.example.demo.specification;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.domain.Specification;

public class AccountSpecification {

    public static Specification<Account> usernameEquals(String username) {
        return (root, query, builder) -> builder.equal(root.get("username"), username);
    }
}