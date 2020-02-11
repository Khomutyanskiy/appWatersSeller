package com.example.appwaterssaller;

public class Product {


    int    Id;
    String Name;
    Double Сapacity;
    String Description;
    Double Price;
    String Img;

    public Product(int id, String name, Double сapacity, String description, Double price, String img) {
        Id = id;
        Name = name;
        Сapacity = сapacity;
        Description = description;
        Price = price;
        Img = img;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getСapacity() {
        return Сapacity;
    }

    public void setСapacity(Double сapacity) {
        Сapacity = сapacity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
