package ru.gb.pugacheva.lesson2homework;

public class Product {
    private int id;
    private String title;
    private int price;

    public int getId() {
        return id;
    }


    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
