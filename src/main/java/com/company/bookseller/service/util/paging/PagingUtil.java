package com.company.bookseller.service.util.paging;

import com.company.bookseller.dao.connection.ConnectionManager;
import jakarta.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.Logger;

public class PagingUtil {
    public static Paging extractPaging(HttpServletRequest request) {
        String limitStr = request.getParameter("limit");
        int limit;
        if (limitStr == null) {
            limit = 5;
        } else {
            limit = Integer.parseInt(limitStr);
        }
        String pageStr = request.getParameter("page");
        int page;
        if (pageStr == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageStr);
        }
        int offset = (page - 1) * limit;
        return new Paging(limit, offset);
    }

    public static int getCurrentPage(Paging paging) {
        return paging.getOffset() / paging.getLimit() + 1;


    }

    public static long getTotalPages(long totalItems, int limit) {
        return totalItems / limit + (totalItems % limit != 0 ? 1 : 0);
    }

    public static long totalCounter(ConnectionManager connectionManager, String count, Logger log) {
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(count);
            if (resultSet.next()) {
                return resultSet.getLong("total");
            }
        } catch (SQLException e) {
            log.error(e);
        }
        throw new RuntimeException("....");
    }
}




