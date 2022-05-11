package com.company.bookseller.controller;

import com.company.bookseller.controller.impl.ErrorCommand;
import com.company.bookseller.controller.impl.add.AddBookCommand;
import com.company.bookseller.controller.impl.add.RegisterCommand;
import com.company.bookseller.controller.impl.get.GetBookCommand;
import com.company.bookseller.controller.impl.get.GetBooksCommand;
import com.company.bookseller.controller.impl.get.GetOrderCommand;
import com.company.bookseller.controller.impl.get.GetOrdersCommand;
import com.company.bookseller.controller.impl.get.GetProfileCommand;
import com.company.bookseller.controller.impl.get.GetUsersCommand;

public enum Commands {
    REGISTER(new RegisterCommand()),
    PROFILE(new GetProfileCommand()),
    USERS(new GetUsersCommand()),
    ADDBOOK(new AddBookCommand()),
    BOOK(new GetBookCommand()),
    BOOKS(new GetBooksCommand()),
    ORDER(new GetOrderCommand()),
    ORDERS(new GetOrdersCommand()),
    ERROR(new ErrorCommand());

    Commands(Command command) {
        this.command = command;
    }

    private final Command command;

    public Command get() {
        return command;
    }
}
