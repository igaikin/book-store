package com.company.bookseller.controller;

import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.dao.connection.ConnectionManager;
import com.company.bookseller.service.BookService;
import com.company.bookseller.service.OrderService;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.impl.BookServiceImpl;
import com.company.bookseller.service.impl.OrderServiceImpl;
import com.company.bookseller.service.impl.UserServiceImpl;
import com.company.bookseller.service.util.Printer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class App {

    private static final BookService bookService = new BookServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final String SEPARATOR = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

    public static void main(String[] args) {
        try {
//            List<OrderDto> orders = orderService.getAll();
//            print(orders);

            testBook();
//            testUser();
//            testOrder();
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
    }

    @SuppressWarnings("unchecked")
    private static void print(Object o) {
        List<?> l;
        if (!(o instanceof List<?>)) {
            l = List.of(o);
        } else {
            l = (List<?>) o;
        }
        String str = "";
        if (l.get(0) instanceof BookDto) {
            str = Printer.getBookFormattedTable((List<BookDto>) l);
        }
        if (l.get(0) instanceof OrderDto) {
            str = Printer.getOrderFormattedTable((List<OrderDto>) l);
        }
        if (l.get(0) instanceof UserDto) {
            str = Printer.getUserFormattedTable((List<UserDto>) l);
        }
        System.out.println(str);

    }

    private static UserDto getRandomUser() {
        List<UserDto> users = userService.getAll();
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    private static BookDto getRandomBook() {
        List<BookDto> books = bookService.getAll();
        Random random = new Random();
        return books.get(random.nextInt(books.size()));
    }

//    private static void testOrder() {
//        Order order = new Order();
//        User user = getRandomUser();
//        order.setUser(user);
//        Book book = getRandomBook();
//        order.setBook(book);
//        int quantity = 99;
//        order.setQuantity(quantity);
//        order.setStatus(Order.Status.PENDING);
//        BigDecimal price = order.getBook().getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
//        order.setTotalPrice(price);
//        Order createdOrder = orderService.create(order);
//
//        Order orderToRead = orderService.get(createdOrder.getId());
//        print(orderToRead);
//
//        createdOrder.setStatus(Order.Status.DELIVERED);
//        orderService.update(createdOrder);
//
//        List<Order> orders = orderService.getAll();
//        print(orders);
//
//        orderService.delete(createdOrder.getId());
//    }

    private static void testBook() {
        BookDto bookDto = new BookDto();
        bookDto.setAuthor("Rudyard Kipling");
        bookDto.setTitle("The Jungle Book");
        bookDto.setCover(BookDto.Cover.HARD);
        bookDto.setNumberOfPages(110);
        bookDto.setIsbn("978-1-38-729890-7");
        bookDto.setPrice(BigDecimal.valueOf(23.86));
        BookDto createdBook = bookService.create(bookDto);

        System.out.println("\t\tCREATE\n" + SEPARATOR);
        print(createdBook);

        BookDto bookToRead = bookService.get(createdBook.getId());
        System.out.println("\t\tGET\n" + SEPARATOR);
        print(bookToRead);

        createdBook.setAuthor("XXXXXX");
        createdBook.setTitle("XXXXXX");
        bookService.update(createdBook);
        System.out.println("\t\tUPDATE\n" + SEPARATOR);
        print(bookService.get(createdBook.getId()));

        List<BookDto> books = bookService.getAll();
        System.out.println("\t\tGET ALL\n" + SEPARATOR);
        print(books);

        bookService.delete(createdBook.getId());

        System.out.println("\t\tAFTER DELETE\n" + SEPARATOR);
        print(bookService.getAll());
    }

    private static void testUser() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Ivan");
        userDto.setLastName("Ivanov");
        userDto.setRole(UserDto.Role.CUSTOMER);
        userDto.setEmail("ivan@mail.ru");
        userDto.setPassword("vankavstanka");
        UserDto createdUser = userService.create(userDto);

        UserDto userToRead = userService.get(createdUser.getId());
        print(userToRead);

        createdUser.setFirstName("XXXXXX");
        createdUser.setLastName("XXXXXX");
        userService.update(createdUser);

        List<UserDto> users = userService.getAll();
        print(users);

        userService.delete(createdUser.getId());
    }
}
