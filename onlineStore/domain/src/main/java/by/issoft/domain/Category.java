package by.issoft.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Category {
    private String name;
    private List<Product> productList;

    //this is constructor
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

    public void addProduct(Product product) {
        productList.add(product);

    }

    public void printAllProducts() {

        System.out.println("-------------------------------------------------");
        System.out.println("Category: " + name + ".");
        System.out.println("------------------------------------------------");

        for (Product product : productList) {
            System.out.println(product.toString());
        }


    }
}
