package com.company.bookseller.service;

import com.company.bookseller.service.dto.BookDto;
import java.util.List;

public interface BookService extends AbstractService<BookDto, Long> {
    List<BookDto> getSearch(String search);
}
