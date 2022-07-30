package com.company.bookseller.service.util.paging;

import jakarta.servlet.http.HttpServletRequest;

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
}




