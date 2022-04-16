package com.example.networkbook_app;

public class Book {

    private String id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String category_id;

    public Book(String id,String author,double price,int pages, String name,String category_id){

        this.id = id;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.name = name;
        this.category_id = category_id;
    }

    public String getId(){
        return id;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getPages(){
        return pages;
    }
    public String getName(){
        return name;
    }
    public String getCategory_id(){
        return category_id;
    }

}
