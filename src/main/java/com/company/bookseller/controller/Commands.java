package com.company.bookseller.controller;

import com.company.bookseller.controller.impl.ErrorCommand;
import com.company.bookseller.controller.impl.add.AddBookCommand;
import com.company.bookseller.controller.impl.add.AddBookFormCommand;
import com.company.bookseller.controller.impl.add.RegisterCommand;
import com.company.bookseller.controller.impl.add.RegisterUserFormCommand;
import com.company.bookseller.controller.impl.delete.DeleteBookCommand;
import com.company.bookseller.controller.impl.delete.DeleteUserCommand;
import com.company.bookseller.controller.impl.get.GetBookCommand;
import com.company.bookseller.controller.impl.get.GetBooksCommand;
import com.company.bookseller.controller.impl.get.GetOrderCommand;
import com.company.bookseller.controller.impl.get.GetOrdersCommand;
import com.company.bookseller.controller.impl.get.GetProfileCommand;
import com.company.bookseller.controller.impl.get.GetUsersCommand;
import com.company.bookseller.controller.impl.update.EditBookCommand;
import com.company.bookseller.controller.impl.update.EditBookFormCommand;
import com.company.bookseller.controller.impl.update.EditProfileCommand;
import com.company.bookseller.controller.impl.update.EditProfileFormCommand;

public enum Commands {
    REGISTER(new RegisterCommand()),
    REGISTERUSERFORM(new RegisterUserFormCommand()),
    EDITPROFILE(new EditProfileCommand()),
    EDITPROFILEFORM(new EditProfileFormCommand()),
    PROFILE(new GetProfileCommand()),
    USERS(new GetUsersCommand()),
    DELETEUSER(new DeleteUserCommand()),
    ADDBOOK(new AddBookCommand()),
    EDITBOOK(new EditBookCommand()),
    EDITBOOKFORM(new EditBookFormCommand()),
    BOOK(new GetBookCommand()),
    DELETEBOOK(new DeleteBookCommand()),
    BOOKS(new GetBooksCommand()),
    ORDER(new GetOrderCommand()),
    ORDERS(new GetOrdersCommand()),
    ADDBOOKFORM(new AddBookFormCommand()),
    ERROR(new ErrorCommand());

    Commands(Command command) {
        this.command = command;
    }

    private final Command command;

    public Command get() {
        return command;
    }
}
