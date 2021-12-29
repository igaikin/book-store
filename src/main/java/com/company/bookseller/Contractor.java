package com.company.bookseller;

import com.company.bookseller.model.beans.entities.Book;
import com.company.bookseller.model.beans.entities.User;
import com.company.bookseller.model.dao.connection.ConnectionManager;
import com.company.bookseller.model.service.BookService;
import com.company.bookseller.model.service.UserService;
import com.company.bookseller.model.service.impl.BookServiceImpl;
import com.company.bookseller.model.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Contractor {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
//
        List<Book> previewBooks = bookService.getPreviewBooks();
        for (Book books : previewBooks) {
            System.out.println(books.getPreviewFormattedOutput());
        }

//        List<User> users = userService.getAll();
//        System.out.println(users);
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Please enter the ID to see detailed information for the book and user: ");
                long id = scanner.nextLong();
                if (id <= 0) {
                    break;
                }

                Book book = bookService.getById(id);
                try {
                    System.out.println(book.getFormattedOutput());
                } catch (NullPointerException e) {
                    System.out.println("Book with this ID does not exist");
                }

                User user = userService.getById(id);
                try {
                    System.out.println(user.getFormattedOutput());
                } catch (NullPointerException e) {
                    System.out.println("User with this ID does not exist");
                }

//                Order order = orderService.getById(id);try {
//                    System.out.println(order.getFormattedOutput());
//                } catch (NullPointerException e) {
//                    System.out.println("Order with this ID does not exist");
//                }
//                System.out.println();
//                System.out.println(book.getOrder().getFormattedOutput());
            }
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
    }
}
