package com.sample;

public class Order {

    private long id;

    private int price;

    public Order() {}

    public Order(long id, int price) {
        super();
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
