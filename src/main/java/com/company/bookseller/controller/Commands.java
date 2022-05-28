package com.company.bookseller.controller;

import com.company.bookseller.controller.impl.AddToCartCommand;
import com.company.bookseller.controller.impl.ErrorCommand;
import com.company.bookseller.controller.impl.LoginCommand;
import com.company.bookseller.controller.impl.LoginPageCommand;
import com.company.bookseller.controller.impl.book.AddBookCommand;
import com.company.bookseller.controller.impl.book.AddBookFormCommand;
import com.company.bookseller.controller.impl.book.DeleteBookCommand;
import com.company.bookseller.controller.impl.book.EditBookCommand;
import com.company.bookseller.controller.impl.book.EditBookFormCommand;
import com.company.bookseller.controller.impl.book.GetBookCommand;
import com.company.bookseller.controller.impl.book.GetBooksCommand;
import com.company.bookseller.controller.impl.order.CreateOrderCommand;
import com.company.bookseller.controller.impl.order.CreateOrderFormCommand;
import com.company.bookseller.controller.impl.order.DeleteOrderCommand;
import com.company.bookseller.controller.impl.order.GetOrderCommand;
import com.company.bookseller.controller.impl.order.GetOrdersCommand;
import com.company.bookseller.controller.impl.user.DeleteUserCommand;
import com.company.bookseller.controller.impl.user.EditProfileCommand;
import com.company.bookseller.controller.impl.user.EditProfileFormCommand;
import com.company.bookseller.controller.impl.user.GetProfileCommand;
import com.company.bookseller.controller.impl.user.GetUsersCommand;
import com.company.bookseller.controller.impl.user.RegisterCommand;
import com.company.bookseller.controller.impl.user.RegisterUserFormCommand;

public enum Commands {
    REGISTER(new RegisterCommand()),
    REGISTERUSERFORM(new RegisterUserFormCommand()),
    EDITPROFILE(new EditProfileCommand()),
    EDITPROFILEFORM(new EditProfileFormCommand()),
    PROFILE(new GetProfileCommand()),
    USERS(new GetUsersCommand()),
    DELETEUSER(new DeleteUserCommand()),


    ADD_BOOK(new AddBookCommand()),
    ADDBOOKFORM(new AddBookFormCommand()),
    EDITBOOK(new EditBookCommand()),
    EDITBOOKFORM(new EditBookFormCommand()),
    BOOK(new GetBookCommand()),
    BOOKS(new GetBooksCommand()),
    DELETEBOOK(new DeleteBookCommand()),


    CREATEORDER(new CreateOrderCommand()),
    CREATEORDERFORM(new CreateOrderFormCommand()),
    ORDER(new GetOrderCommand()),
    ORDERS(new GetOrdersCommand()),
    DELETEORDER(new DeleteOrderCommand()),


    ERROR(new ErrorCommand()),
    ADD_TO_CART(new AddToCartCommand()),
    LOGIN(new LoginCommand()),
    LOGIN_PAGE(new LoginPageCommand());

    Commands(Command command) {
        this.command = command;
    }

    private final Command command;

    public Command get() {
        return command;
    }
}
