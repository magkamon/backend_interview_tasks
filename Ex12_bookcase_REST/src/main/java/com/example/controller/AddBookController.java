package com.example.controller;

import com.example.dto.BookForm;
import com.example.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("book")
public class AddBookController {

    private final BookService bookService;

    @Autowired
    public AddBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation("Dodanie nowej książki")
    @PostMapping("/add")
    public BookForm submitNewBook(@Valid @RequestBody BookForm bookForm) {
        return bookService.addBook(bookForm);
    }

}
