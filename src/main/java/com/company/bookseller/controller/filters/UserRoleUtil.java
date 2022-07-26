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
            case "USERS",
                    "DELETE_USER",
                    "ADD_BOOK",
                    "ADD_BOOK_FORM",
                    "EDIT_BOOK",
                    "EDIT_BOOK_FORM",
                    "DELETE_BOOK" -> true;
            default -> false;
        };
    }

    public static boolean isManagerAction(String command) {
        if (command == null) {
            return false;
        }
        command = command.toUpperCase();
        return /*switch (command) {
            case "CHANGE_LANGUAGE",
                    "PROFILE",
                    "EDIT_PROFILE",
                    "EDIT_PROFILE_FORM",
                    "USERS",
                    "BOOK",
                    "BOOKS",
                    "ERROR",
                    "LOGIN",
                    "LOGIN_PAGE",
                    "LOGOUT",
                    "CREATE_ORDER",
                    "ORDER",
                    "ORDERS",
                    "DELETE_ORDER" -> true;
            default ->*/ false;
    }
}

//*****************************************GUEST
//"REGISTER"
//"REGISTER_USER_FORM"
//"CHANGE_LANGUAGE"
//"BOOK"
//"BOOKS"
//"ERROR"
//"LOGIN"
//"LOGIN_PAGE"


//*****************************************USER
//"CHANGE_LANGUAGE",
//"EDIT_PROFILE",
//"EDIT_PROFILE_FORM",
//"PROFILE",
//"BOOK",
//"BOOKS",
//"ERROR",
//"LOGIN",
//"LOGIN_PAGE",
//"LOGOUT",
//"ADD_TO_CART",
//"CART",
//"CREATE_ORDER",
//"ORDER",
//"ORDERS",
//"DELETE_ORDER"


//******************************************MANAGER
//"CHANGE_LANGUAGE",
//"PROFILE",
//"EDIT_PROFILE",
//"EDIT_PROFILE_FORM",
//"USERS",
//"BOOK",
//"BOOKS",
//"ERROR",
//"LOGIN",
//"LOGIN_PAGE",
//"LOGOUT",
//"CREATE_ORDER",
//"ORDER",
//"ORDERS",
//"DELETE_ORDER"


//******************************************ADMIN
//"CHANGE_LANGUAGE",
//"PROFILE",
//"EDIT_PROFILE",
//"EDIT_PROFILE_FORM",
//"USERS",
//"DELETE_USER",
//"ADD_BOOK",
//"ADD_BOOK_FORM",
//"EDIT_BOOK",
//"EDIT_BOOK_FORM",
//"DELETE_BOOK",
//"BOOK",
//"BOOKS",
//"ERROR",
//"LOGIN",
//"LOGIN_PAGE",
//"LOGOUT"
