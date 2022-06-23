package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.OrderItem;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaoFactory {
    public static DaoFactory getInstance() {
        return DaoFactory.Holder.INSTANCE;
    }

    private static class Holder {
        static final DaoFactory INSTANCE = new DaoFactory();
    }

    public Object getDao(String daoName) {
        return DaoRegister.valueOf(daoName).getDao();
    }
}

enum DaoRegister {
    BOOK_DAO(BookDao.class),
    USER_DAO(UserDao.class),
    ORDER_DAO(OrderDao.class),
    ORDER_ITEM_DAO(OrderItem.class);


    private final Object dao;

    DaoRegister(Object dao) {
        this.dao = dao;
    }

    public Object getDao() {
        return dao;
    }
}
