package com.company.bookseller.controller.commands;

import com.company.bookseller.controller.commands.impl.AddToCartCommand;
import com.company.bookseller.controller.commands.impl.ErrorCommand;
import com.company.bookseller.controller.commands.impl.LoginCommand;
import com.company.bookseller.controller.commands.impl.LoginPageCommand;
import com.company.bookseller.controller.commands.impl.LogoutCommand;
import com.company.bookseller.controller.commands.impl.book.AddBookCommand;
import com.company.bookseller.controller.commands.impl.book.AddBookFormCommand;
import com.company.bookseller.controller.commands.impl.book.DeleteBookCommand;
import com.company.bookseller.controller.commands.impl.book.EditBookCommand;
import com.company.bookseller.controller.commands.impl.book.EditBookFormCommand;
import com.company.bookseller.controller.commands.impl.book.GetBookCommand;
import com.company.bookseller.controller.commands.impl.book.GetBooksCommand;
//import com.company.bookseller.controller.commands.impl.order.CreateOrderCommand;
//import com.company.bookseller.controller.commands.impl.order.CreateOrderFormCommand;
import com.company.bookseller.controller.commands.impl.order.DeleteOrderCommand;
//import com.company.bookseller.controller.commands.impl.order.GetCartCommand;
import com.company.bookseller.controller.commands.impl.order.GetOrderCommand;
import com.company.bookseller.controller.commands.impl.order.GetOrdersCommand;
import com.company.bookseller.controller.commands.impl.user.DeleteUserCommand;
import com.company.bookseller.controller.commands.impl.user.EditProfileCommand;
import com.company.bookseller.controller.commands.impl.user.EditProfileFormCommand;
import com.company.bookseller.controller.commands.impl.user.GetProfileCommand;
import com.company.bookseller.controller.commands.impl.user.GetUsersCommand;
import com.company.bookseller.controller.commands.impl.user.RegisterCommand;
import com.company.bookseller.controller.commands.impl.user.RegisterUserFormCommand;

public enum Commands {
    REGISTER(new RegisterCommand()),
    REGISTER_USER_FORM(new RegisterUserFormCommand()),
    EDIT_PROFILE(new EditProfileCommand()),
    EDIT_PROFILE_FORM(new EditProfileFormCommand()),
    PROFILE(new GetProfileCommand()),
    USERS(new GetUsersCommand()),
    DELETE_USER(new DeleteUserCommand()),


    ADD_BOOK(new AddBookCommand()),
    ADD_BOOK_FORM(new AddBookFormCommand()),
    EDIT_BOOK(new EditBookCommand()),
    EDIT_BOOK_FORM(new EditBookFormCommand()),
    BOOK(new GetBookCommand()),
    BOOKS(new GetBooksCommand()),
    DELETE_BOOK(new DeleteBookCommand()),


//    CREATE_ORDER(new CreateOrderCommand()),
    ORDER(new GetOrderCommand()),
    ORDERS(new GetOrdersCommand()),
    DELETE_ORDER(new DeleteOrderCommand()),
//    CART(new GetCartCommand()),


    ERROR(new ErrorCommand()),
    ADD_TO_CART(new AddToCartCommand()),
    LOGIN(new LoginCommand()),
    LOGIN_PAGE(new LoginPageCommand()),
    LOGOUT(new LogoutCommand());

    Commands(Command command) {
        this.command = command;
    }

    private final Command command;

    public Command get() {
        return command;
    }
}
