package com.example.repository;

import com.example.dto.BookForm;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProvider {

    public List<BookForm> books = new ArrayList<>();

}
