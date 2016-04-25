package com.kaishengit.pojo;

import java.io.Serializable;

public class Book implements Serializable {

    private Integer id;
    private String bookName;
    private Float bookPrice;

    public Book(){}

    public Book(Integer id,String bookName,Float bookPrice) {
        this.id = id;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Float bookPrice) {
        this.bookPrice = bookPrice;
    }
}
