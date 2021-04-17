package com.example.service;


import com.example.dto.BookForm;
import com.example.repository.BookProvider;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookService {

    private final BookProvider bookProvider;

    public BookService(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public BookForm addBook(BookForm bookForm) {
        bookProvider.books.add(bookForm);
        return bookForm;
    }

    public List<BookForm> getAllBooks() {
        return bookProvider.books;
    }

    public List<BookForm> getBooksByIbanAsc() {
        List<BookForm> books = getAllBooks();
        return books.stream().sorted(Comparator.comparing(BookForm::getIban)).collect(toList());
    }

    public List<BookForm> getBooksContainingGivenIban(String iban) {
        List<BookForm> books = getAllBooks();
        return books.stream()
                .filter(bookEntity -> bookEntity.getIban().contains(iban))
                .collect(toList());
    }

    public List<BookForm> getBookByTitleContainingGivenPhrase(String phrase) {
        List<BookForm> books = getAllBooks();
        return books.stream()
                .filter(bookEntity -> bookEntity.getTitle().toLowerCase().contains(phrase.toLowerCase()))
                .collect(toList());
    }

}
