package com.company.bookseller;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.beans.Order;
import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.connection.ConnectionManager;
import com.company.bookseller.model.service.BookService;
import com.company.bookseller.model.service.OrderService;
import com.company.bookseller.model.service.UserService;
import com.company.bookseller.model.service.impl.BookServiceImpl;
import com.company.bookseller.model.service.impl.OrderServiceImpl;
import com.company.bookseller.model.service.impl.UserServiceImpl;
import com.company.bookseller.model.service.util.Printer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static com.company.bookseller.model.beans.Book.Cover.HARD;

public class Contractor {
    public static void main(String[] args) {

        BookService bookService = new BookServiceImpl();

        Book book = new Book();
//        book.setId(20);
        book.setAuthor("Rudyard Kipling");
        book.setTitle("The Jungle Book");
        book.setCover(HARD);
        book.setNumberOfPages(110);
        book.setPrice(BigDecimal.valueOf(23.86));
        bookService.create(book);

        List<Book> previewBooks = bookService.getAll();
        String tableBooks = Printer.getBookFormattedTable(previewBooks);
        System.out.println(tableBooks);

        UserService userService = new UserServiceImpl();
        List<User> previewUsers = userService.getAll();
        String tableUsers = Printer.getUserFormattedTable(previewUsers);
        System.out.println(tableUsers);

        OrderService orderService = new OrderServiceImpl();
        List<Order> previewOrders = orderService.getAll();
        String tableOrders = Printer.getOrderFormattedTable(previewOrders);
        System.out.println(tableOrders);

        Order order = new Order();
        long userId = 1;
        User user = userService.get(userId);
        order.setUser(user);
        long bookId = 16;
        Book book = bookService.get(bookId);
        order.setBook(book);
        int quantity = 2;
        order.setQuantity(quantity);
        order.setStatus(Order.Status.PENDING);
        BigDecimal price = order.getBook().getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
        order.setTotalPrice(price);
        orderService.create(order);

        orderService.getAll();
        Scanner scanner = new Scanner(System.in);
        try {
//            while (true) {
//                System.out.print("Please enter the ID to see detailed information for the list Books: ");
//                long id = scanner.nextLong();
//                if (id <= 0) {
//                    break;
//                }
//                Book book = bookService.getById(id);
//                if (book != null) {
//                    System.out.println(book.getFormattedOutput());
//                } else {
//                    System.out.println("Book with this ID does not exist");
//                }
//            }
//            while (true) {
//                System.out.print("Please enter the ID to see detailed information for the list Users: ");
//                long id = scanner.nextLong();
//                if (id <= 0) {
//                    break;
//                }
//                User user = userService.getById(id);
//                if (user != null) {
//                    System.out.println(user.getFormattedOutput());
//                } else {
//                    System.out.println("User with this ID does not exist");
//                }
//            }
//            while (true) {
//                System.out.print("Please enter the ID to see detailed information for the list Orders: ");
//                long id = scanner.nextLong();
//                if (id <= 0) {
//                    break;
//                }
//                Order order = orderService.getById(id);
//                if (order != null) {
//                    System.out.println(order.getFormattedOutput());
//                } else {
//                    System.out.println("Order with this ID does not exist");
//                }
//            }
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
    }
}
