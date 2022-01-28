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
import java.util.Random;

import static com.company.bookseller.model.beans.Book.Cover.HARD;

public class Contractor {

    private static final BookService bookService = new BookServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();

    private static void print(Object o) {
        List l;
        if (!(o instanceof List)) {
            l = List.of(o);
        } else {
            l = (List) o;
        }
        String str = "";
        if (l.get(0) instanceof Book) {
            str = Printer.getBookFormattedTable(l);
        }
        if (l.get(0) instanceof Order) {
            str = Printer.getOrderFormattedTable(l);
        }
        if (l.get(0) instanceof User) {
            str = Printer.getUserFormattedTable(l);
        }
        System.out.println(str);

    }

    public static void main(String[] args) {
        try {
            testBook();
            //FIXME test user
            testOrder();
        } finally {
            ConnectionManager.getInstance().tearDown();
        }
    }

    private static User getRandomUser() {
        List<User> users = userService.getAll();
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }

    private static Book getRandomBook() {
        List<Book> books = bookService.getAll();
        Random random = new Random();
        return books.get(random.nextInt(books.size()));
    }

    private static void testOrder() {
        Order order = new Order();
        User user = getRandomUser();
        order.setUser(user);
        Book book = getRandomBook();
        order.setBook(book);
        int quantity = 99;
        order.setQuantity(quantity);
        order.setStatus(Order.Status.PENDING);
        BigDecimal price = order.getBook().getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
        order.setTotalPrice(price);
        Order createdOrder = orderService.create(order);

        Order orderToRead = orderService.get(createdOrder.getId());
        print(orderToRead);

        createdOrder.setStatus(Order.Status.DELIVERED);
        orderService.update(createdOrder);

        List<Order> orders = orderService.getAll();
        print(orders);

        orderService.delete(createdOrder.getId());
    }

    private static void testBook() {
        Book book = new Book();
        book.setAuthor("Rudyard Kipling");
        book.setTitle("The Jungle Book");
        book.setCover(HARD);
        book.setNumberOfPages(110);
        book.setPrice(BigDecimal.valueOf(23.86));
        Book createdBook = bookService.create(book);

        Book bookToRead = bookService.get(createdBook.getId());
        print(bookToRead);

        createdBook.setAuthor("XXXXXX");
        createdBook.setTitle("XXXXXX");
        bookService.update(createdBook);

        List<Book> books = bookService.getAll();
        print(books);

        bookService.delete(createdBook.getId());
    }
}
