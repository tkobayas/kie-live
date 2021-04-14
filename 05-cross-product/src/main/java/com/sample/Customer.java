package com.sample;

public class Customer {

    private String name;

    private int extraDiscount;

    public Customer() {}

    public Customer(String name, int extraDiscount) {
        super();
        this.name = name;
        this.extraDiscount = extraDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraDiscount() {
        return extraDiscount;
    }

    public void setExtraDiscount(int extraDiscount) {
        this.extraDiscount = extraDiscount;
    }

}
