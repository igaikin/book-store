package com.company.bookseller.service;

import com.company.bookseller.dao.BookDao;
import com.company.bookseller.dao.DaoFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceFactory {
    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public Object getService(String serviceName) {
        return ServiceRegister.valueOf(serviceName).getService();
    }
}

enum ServiceRegister {
    BOOK_SERVICE((BookDao) DaoFactory.getInstance().getDao("BOOK_DAO")),
    USER_SERVICE(DaoFactory.getInstance().getDao("USER_DAO")),
    CART_SERVICE(DaoFactory.getInstance().getDao("ORDER_ITEM_DAO")),
    ORDER_SERVICE(DaoFactory.getInstance().getDao("ORDER_DAO"));

    private final Object service;

    ServiceRegister(Object service) {
        this.service = service;
    }

    public Object getService() {
        return service;
    }
}
