package com.company.bookseller.service.util.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Paging {
    private Integer limit;
    private Integer offset;
}
