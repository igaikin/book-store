package com.company.bookseller.model.beans;

import lombok.Data;
import lombok.Getter;

@Data
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;

    public enum Role {
        CUSTOMER("Customer"),
        MANAGER("Manager"),
        ADMIN("Administrator");

        @Getter
        private final String name;

        Role(String name) {
            this.name = name;
        }
    }
}
