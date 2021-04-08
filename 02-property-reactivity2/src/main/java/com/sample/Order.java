package com.sample;

public class Order {

    private long id;

    private String item;

    private int price;

    private int discount;

    public Order(long id, String item, int price, int discount) {
        super();
        this.id = id;
        this.item = item;
        this.price = price;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean checkSpecialItem() {
        return item.equals("Guitar");
    }

    
    public boolean highPrice() {
        return price > 5000;
    }
    
    @Override
    public String toString() {
        return "Order [id=" + id + ", item=" + item + ", price=" + price + ", discount=" + discount + "]";
    }

}
