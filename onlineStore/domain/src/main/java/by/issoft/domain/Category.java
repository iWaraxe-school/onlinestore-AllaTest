package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    private List<Product> productList;

    //this is construtor
    public Category(String name) {
        this.name = name;
        this.productList = new ArrayList<>();

    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getName() {

        return name;
    }

    public void addProduct(Product product) { //investigate
        productList.add(product);

    }

    public void printAllProducts() {

        //System.out.println(String.format("s% -------------------------------------------------"));
        System.out.println("Category: " + name + ".");
        //System.out.println(String.format("s% -------------------------------------------------"));

        for (Product product : productList) {
            System.out.println(product.toString());
        }


    }
}
