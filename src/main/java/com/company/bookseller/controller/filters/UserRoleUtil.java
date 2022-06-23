package com.company.bookseller.controller.filters;

public class UserRoleUtil {

    public static boolean isAuthorizationRequired(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return switch (command) {
            case "REGISTER",
                    "REGISTER_USER_FORM",
                    "LOGIN",
                    "LOGIN_PAGE",
                    "ADD_TO_CART",
                    "ERROR",
                    "CREATE_ORDER",
                    "BOOK",
                    "BOOKS",
                    "CHANGE_LANGUAGE",
                    "CART" -> false;

            default -> true;
        };
    }

    public static boolean isAdminAction(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return switch (command) {
            case "ADD_BOOK",
                    "ADD_BOOK_FORM",
                    "EDIT_BOOK",
                    "DELETE_BOOK",
                    "EDIT_BOOK_FORM" -> true;
            default -> false;
        };
    }

    public static boolean isManagerAction(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return switch (command) {
            case "ORDERS",
                    "DELETE_ORDER" -> true;
            default -> false;
        };
    }

    public static boolean isCustomerAction(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return switch (command) {
            case "EDIT_PROFILE_FORM",
                    "PROFILE",
                    "BOOK",
                    "ORDER",
                    "ORDERS",
                    "DELETE_ORDER",
                    "ERROR",
                    "ADD_TO_CART" -> true;
            default -> false;
        };
    }
}
//    REGISTER
//REGISTER_USER_FORM
//EDIT_PROFILE
//EDIT_PROFILE_FORM
//PROFILE
//USERS
//DELETE_USER
//
//ADD_BOOK
//ADD_BOOK_FORM
//EDIT_BOOK
//EDIT_BOOK_FORM
//BOOK
//BOOKS
//DELETE_BOOK
//
//CREATE_ORDER
//ORDER
//ORDERS
//DELETE_ORDER
//ADD_TO_CART
//CART
//
//ERROR
//CHANGE_LANGUAGE
//LOGIN
//LOGIN_PAGE
//LOGOUT