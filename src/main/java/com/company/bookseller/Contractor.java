package com.company.bookseller;

import com.company.bookseller.model.beans.Order;
import com.company.bookseller.model.dao.connection.ConnectionManager;
import com.company.bookseller.model.service.OrderService;
import com.company.bookseller.model.service.impl.OrderServiceImpl;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Contractor {
    public static void main(String[] args) {

//        BookService bookService = new BookServiceImpl();
//        UserService userService = new UserServiceImpl();
        OrderService orderService = new OrderServiceImpl();

//
//        List<Book> previewBooks = bookService.getPreviewBooks();
//        String table = Printer.getBookFormattedTable(previewBooks);
//        System.out.println(table);

//        List<User> users = userService.getAll();
//        users.forEach(System.out::println);

        List<Order> orders = orderService.getAll();
        orders.forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Please enter the ID to see detailed information for the list item: ");
                long id = scanner.nextLong();
                if (id <= 0) {
                    break;
                }

//                Book book = bookService.getById(id);
//                if (book != null) {
//                    System.out.println(book.getFormattedOutput());
//                } else {
//                    System.out.println("Book with this ID does not exist");
//                }
//                User user = userService.getById(id);
//                if (user != null) {
//                    System.out.println(user.getFormattedOutput());
//                } else {
//                    System.out.println("User with this ID does not exist");
//                }
                Order order = orderService.getById(id);
                if (order != null) {
                    System.out.println(order.getFormattedOutput());
                } else {
                    System.out.println("Order with this ID does not exist");
                }
//                System.out.println();
//                System.out.println(book.getOrder().getFormattedOutput());
            }
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
    }
}
