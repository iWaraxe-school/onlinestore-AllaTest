package by.issoft.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private double rate;

    public Product(String name, double price, double rate) {
        this.name = name;
        this.price = price;
        this.rate = rate;
    }

    //added getters ans setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    @Override
    public String toString() {

        String productInfo = String.format("Name:'%s', Price: '%s', Rate: '%s'", name, price, rate);
        return productInfo;
    }


    }
}
