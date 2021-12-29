package com.company.bookseller.model.beans.entities;

import com.company.bookseller.model.beans.order.Order;
import lombok.Data;
import lombok.Getter;

@Data
public class User {
    long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;
    private Order order;

    public enum Role {
        CUSTOMER("Customer"),
        MANAGER("Manager"),
        ADMIN("Administrator");

        @Getter
        private String name;

        Role(String name) {
            this.name = name;
        }
    }

    public String getAllUsersList() {
        return String.format("ID - %d, First Name - %s, Last Name - %s%n", getId(), getFirstName(), getLastName());
    }

    public String getFormattedOutput() {
        return String.format("User:%n"
                        + "ID           | %d%n"
                        + "First Name   | %s%n"
                        + "Last Name    | %s%n"
                        + "Access Rights| %s%n"
                        + "E-mail       | %s%n"
                        + "Password     | %s%n"
                        + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
                getId(), getFirstName(), getLastName(), role.name, getEmail(), getPassword());
    }
}
