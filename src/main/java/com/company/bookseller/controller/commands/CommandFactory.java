package com.company.bookseller.controller.commands;

import com.company.bookseller.controller.commands.impl.ChangeLanguageCommand;
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
import com.company.bookseller.controller.commands.impl.order.AddToCartCommand;
import com.company.bookseller.controller.commands.impl.order.CartCommand;
import com.company.bookseller.controller.commands.impl.order.CreateOrderCommand;
import com.company.bookseller.controller.commands.impl.order.DeleteOrderCommand;
import com.company.bookseller.controller.commands.impl.order.GetOrderCommand;
import com.company.bookseller.controller.commands.impl.order.GetOrdersCommand;
import com.company.bookseller.controller.commands.impl.user.DeleteUserCommand;
import com.company.bookseller.controller.commands.impl.user.EditProfileCommand;
import com.company.bookseller.controller.commands.impl.user.EditProfileFormCommand;
import com.company.bookseller.controller.commands.impl.user.GetProfileCommand;
import com.company.bookseller.controller.commands.impl.user.GetUsersCommand;
import com.company.bookseller.controller.commands.impl.user.RegisterCommand;
import com.company.bookseller.controller.commands.impl.user.RegisterUserFormCommand;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.CartService;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.ServiceFactory;
import com.company.bookseller.service.UserService;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final BookService BOOK_SERVICE = ((BookService) ServiceFactory.getInstance().getService(
            "BOOK_SERVICE"));
    private static final UserService USER_SERVICE = ((UserService) ServiceFactory.getInstance().getService(
            "USER_SERVICE"));
    private static final CartService CART_SERVICE = ((CartService) ServiceFactory.getInstance().getService(
            "CART_SERVICE"));
    private static final OrderService ORDER_SERVICE = ((OrderService) ServiceFactory.getInstance().getService(
            "ORDER_SERVICE"));

    public static CommandFactory getInstance() {
        return CommandFactory.Holder.INSTANCE;
    }

    private static class Holder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }

    private CommandFactory() {
        Map<String, Command> register = new HashMap<>();
        register.put("REGISTER", new RegisterCommand(USER_SERVICE));
        register.put("REGISTER_USER_FORM", new RegisterUserFormCommand());
        register.put("EDIT_PROFILE", new EditProfileCommand(USER_SERVICE));
        register.put("EDIT_PROFILE_FORM", new EditProfileFormCommand(USER_SERVICE));
        register.put("PROFILE", new GetProfileCommand(USER_SERVICE));
        register.put("USERS", new GetUsersCommand(USER_SERVICE));
        register.put("DELETE_USER", new DeleteUserCommand(USER_SERVICE));


        register.put("ADD_BOOK", new AddBookCommand(BOOK_SERVICE));
        register.put("ADD_BOOK_FORM", new AddBookFormCommand());
        register.put("EDIT_BOOK", new EditBookCommand(BOOK_SERVICE));
        register.put("EDIT_BOOK_FORM", new EditBookFormCommand(BOOK_SERVICE));
        register.put("BOOK", new GetBookCommand(BOOK_SERVICE));
        register.put("BOOKS", new GetBooksCommand(BOOK_SERVICE));
        register.put("DELETE_BOOK", new DeleteBookCommand(BOOK_SERVICE));


        register.put("CREATE_ORDER", new CreateOrderCommand(BOOK_SERVICE, CART_SERVICE, ORDER_SERVICE));
        register.put("ORDER", new GetOrderCommand(ORDER_SERVICE));
        register.put("ORDERS", new GetOrdersCommand(ORDER_SERVICE));
        register.put("DELETE_ORDER", new DeleteOrderCommand(ORDER_SERVICE));
        register.put("ADD_TO_CART", new AddToCartCommand());
        register.put("CART", new CartCommand(BOOK_SERVICE, CART_SERVICE));


        register.put("ERROR", new ErrorCommand());
        register.put("CHANGE_LANGUAGE", new ChangeLanguageCommand());
        register.put("LOGIN", new LoginCommand(USER_SERVICE));
        register.put("LOGIN_PAGE", new LoginPageCommand());
        register.put("LOGOUT", new LogoutCommand());
    }

    public Command getCommand(String action) {
        Command command = CommandFactory.getInstance().getCommand("ERROR");
        if (action == null) {
            return command;
        }
        command = CommandFactory.getInstance().getCommand(action);
        return command;
    }
}
