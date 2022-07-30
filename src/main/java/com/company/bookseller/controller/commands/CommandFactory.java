package com.company.bookseller.controller.commands;

import com.company.bookseller.controller.commands.impl.ChangeLanguageCommand;
import com.company.bookseller.controller.commands.impl.ErrorCommand;
import com.company.bookseller.controller.commands.impl.LoginCommand;
import com.company.bookseller.controller.commands.impl.LoginPageCommand;
import com.company.bookseller.controller.commands.impl.LogoutCommand;
import com.company.bookseller.controller.commands.impl.SearchCommand;
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
import com.company.bookseller.controller.commands.impl.order.EditCartCommand;
import com.company.bookseller.controller.commands.impl.order.EditOrderCommand;
import com.company.bookseller.controller.commands.impl.order.EditOrderFormCommand;
import com.company.bookseller.controller.commands.impl.order.GetMyOrdersCommand;
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
    public static CommandFactory getInstance() {
        return CommandFactory.Holder.INSTANCE;
    }

    private static class Holder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }

    private final Map<String, Command> register;

    private CommandFactory() {
        register = new HashMap<>();
        register.put("REGISTER", new RegisterCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("REGISTER_USER_FORM", new RegisterUserFormCommand());
        register.put("EDIT_PROFILE", new EditProfileCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("EDIT_PROFILE_FORM", new EditProfileFormCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("PROFILE", new GetProfileCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("USERS", new GetUsersCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("DELETE_USER", new DeleteUserCommand(ServiceFactory.getInstance().getService(UserService.class)));


        register.put("ADD_BOOK", new AddBookCommand(ServiceFactory.getInstance().getService(BookService.class)));
        register.put("ADD_BOOK_FORM", new AddBookFormCommand());
        register.put("EDIT_BOOK", new EditBookCommand(ServiceFactory.getInstance().getService(BookService.class)));
        register.put("EDIT_BOOK_FORM", new EditBookFormCommand(ServiceFactory.getInstance().getService(BookService.class)));
        register.put("BOOK", new GetBookCommand(ServiceFactory.getInstance().getService(BookService.class)));
        register.put("BOOKS", new GetBooksCommand(ServiceFactory.getInstance().getService(BookService.class)));
        register.put("DELETE_BOOK", new DeleteBookCommand(ServiceFactory.getInstance().getService(BookService.class)));


        register.put("CREATE_ORDER", new CreateOrderCommand(ServiceFactory.getInstance().getService(BookService.class),
                ServiceFactory.getInstance().getService(CartService.class),
                ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("ORDER", new GetOrderCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("ORDERS", new GetOrdersCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("MY_ORDERS", new GetMyOrdersCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("EDIT_ORDER_FORM", new EditOrderFormCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("EDIT_ORDER", new EditOrderCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("DELETE_ORDER", new DeleteOrderCommand(ServiceFactory.getInstance().getService(OrderService.class)));
        register.put("ADD_TO_CART", new AddToCartCommand());
        register.put("CART", new CartCommand(ServiceFactory.getInstance().getService(BookService.class),
                ServiceFactory.getInstance().getService(CartService.class)));
        register.put("EDIT_CART", new EditCartCommand(ServiceFactory.getInstance().getService(BookService.class),
                        ServiceFactory.getInstance().getService(CartService.class)));


        register.put("ERROR", new ErrorCommand());
        register.put("CHANGE_LANGUAGE", new ChangeLanguageCommand());
        register.put("LOGIN", new LoginCommand(ServiceFactory.getInstance().getService(UserService.class)));
        register.put("LOGIN_PAGE", new LoginPageCommand());
        register.put("LOGOUT", new LogoutCommand());
        register.put("SEARCH", new SearchCommand(ServiceFactory.getInstance().getService(BookService.class)));
    }

    public Command getCommand(String action) {
        if (action != null) {
            return register.get(action.toUpperCase());
        }
        return register.get("ERROR");
    }
}
