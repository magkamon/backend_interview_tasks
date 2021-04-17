package com.example.dto;


import com.example.model.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookForm {


    @Size(min = 2, max = 256)
    private String author;
    @Size(min = 2, max = 256)
    private String title;
    private Category category;
    @Positive
    private int pages;
    private boolean forKids;
    @NotEmpty
    private String iban;

    public BookForm() {
    }

    public BookForm(@Size(min = 2, max = 256) String author, @Size(min = 2, max = 256) String title, Category category, @Positive int pages, boolean forKids, @NotEmpty String iban) {
        this.author = author;
        this.title = title;
        this.category = category;
        this.pages = pages;
        this.forKids = forKids;
        this.iban = iban;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public int getPages() {
        return pages;
    }

    public boolean isForKids() {
        return forKids;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setForKids(boolean forKids) {
        this.forKids = forKids;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "BookForm{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", pages=" + pages +
                ", forKids=" + forKids +
                ", Iban='" + iban + '\'' +
                '}';
    }

}
