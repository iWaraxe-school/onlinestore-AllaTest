package by.issoft.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private double rate;

    //Questions:
    // 1) Still do not understand what this method Builder is needed for;
    // 2) Is that a good practice to create method of a Build type first and then a Class Build?
    // 3) I don't see where I can use Builder method in terms of this project's code. In StoreHelper Class? In RandomStorePopulator Class?
    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    public class Builder {
        private String name;
        private double price;
        private double rate;

        // does the empty constructor is obligatory here?
        private Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price){
            this.price = price;
            return this;
        }

        public Builder setRate(double rate){
            this.rate = rate;
            return this;
        }


    }

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

