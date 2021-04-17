package com.example.controller;

import com.example.dto.BookForm;
import com.example.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookcaseController {

    private final BookService bookService;

    @Autowired
    public BookcaseController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation("Lista wszystkich książek")
    @GetMapping
    public List<BookForm> printBookList() {
        return bookService.getAllBooks();
    }

    @ApiOperation("Filtrowanie rosnące po numerze IBAN")
    @GetMapping("/ByIbanAsc")
    public List<BookForm> printBooksByIban() {
        return bookService.getBooksByIbanAsc();
    }

    @ApiOperation("Filtrowanie po numerze IBAN")
    @GetMapping("/Iban")
    public List<BookForm> printBooksContainingIban(@RequestParam String iban) {
        return bookService.getBooksContainingGivenIban(iban);
    }

    @ApiOperation("Filtrowanie po części nazwy książki")
    @GetMapping("/ByPhrase")
    public List<BookForm> printBooksByPhrase(@RequestParam String phrase) {
        return bookService.getBookByTitleContainingGivenPhrase(phrase);
    }

}
