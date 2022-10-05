package by.issoft.domain;

public class Product {
    private String name;
    private double price;
    private double rate;


    public static Builder newBuilder() {

        return new Product().new Builder();
    }

    public class Builder {
        private String name;
        private double price;
        private double rate;


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


        public Product build(){
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;

            return Product.this;

        }

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

