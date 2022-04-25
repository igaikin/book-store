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
//import com.company.bookseller.service.util.Printer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

//            testBook();
//            testUser();
            testOrder();
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
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

    private static void testOrder() {
        OrderDto order = new OrderDto();
        UserDto user = getRandomUser();
        order.setUser(user);
        BookDto book = getRandomBook();
        Map<BookDto, Integer> items = new HashMap<>();
        order.setItems(items);
        items.put(book, 99);
        order.setStatus(OrderDto.StatusDto.PENDING);
        BigDecimal price = book.getPrice().multiply(BigDecimal.valueOf(99));
        order.setTotalPrice(price);
        order.setOrderDateTime(LocalDateTime.now());
        OrderDto createdOrder = orderService.create(order);

        OrderDto orderToRead = orderService.get(createdOrder.getId());
        print(orderToRead);

        createdOrder.setStatus(OrderDto.StatusDto.DELIVERED);
        orderService.update(createdOrder);

        List<OrderDto> orders = orderService.getAll();
        System.out.println(SEPARATOR);
        orders.forEach(App::print);

        orderService.delete(createdOrder.getId());
    }

    private static void print(OrderDto orderToRead) {
        System.out.printf("id: %d Status=%s, User=%s%n", orderToRead.getId(), orderToRead.getStatus(), orderToRead.getUser().getId());
        orderToRead.getItems().forEach((b, q) -> {
            System.out.printf("  x%d -> %s%n", q, b.getTitle());
        });
        System.out.println();
    }

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
        System.out.println(createdBook);

        BookDto bookToRead = bookService.get(createdBook.getId());
        System.out.println("\t\tGET\n" + SEPARATOR);
        System.out.println(bookToRead);

        createdBook.setAuthor("XXXXXX");
        createdBook.setTitle("XXXXXX");
        bookService.update(createdBook);
        System.out.println("\t\tUPDATE\n" + SEPARATOR);
        System.out.println(bookService.get(createdBook.getId()));

        List<BookDto> books = bookService.getAll();
        System.out.println("\t\tGET ALL\n" + SEPARATOR);
        books.forEach(System.out::println);

        bookService.delete(createdBook.getId());

        System.out.println("\t\tAFTER DELETE\n" + SEPARATOR);
        bookService.getAll().forEach(System.out::println);
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
        System.out.println(userToRead);

        createdUser.setFirstName("XXXXXX");
        createdUser.setLastName("XXXXXX");
        userService.update(createdUser);

        List<UserDto> users = userService.getAll();
        users.forEach(System.out::println);

        userService.delete(createdUser.getId());
    }
}
