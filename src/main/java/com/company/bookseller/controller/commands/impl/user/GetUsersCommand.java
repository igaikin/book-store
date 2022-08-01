package com.company.bookseller.controller.commands.impl.user;

import com.company.bookseller.controller.commands.Command;
import com.company.bookseller.service.UserService;
import com.company.bookseller.service.dto.UserDto;
import com.company.bookseller.service.util.paging.Paging;
import com.company.bookseller.service.util.paging.PagingUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersCommand implements Command {
    private final UserService userService;

    public GetUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        Paging paging = PagingUtil.extractPaging(req);
        List<UserDto> users = userService.getAll(paging.getLimit(), paging.getOffset());
        req.setAttribute("currentPage", PagingUtil.getCurrentPage(paging));
        req.setAttribute("lastPage", PagingUtil.getTotalPages(userService.count(), paging.getLimit()));
        req.setAttribute("users", users);
        return "jsp/allUsers.jsp";
    }
}
