package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Category> categoryList = new ArrayList<>();


    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();

        }
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    public List<Product> getAllProductsList() {
        List<Product> allProductsList = new ArrayList<>();
        for (Category category: categoryList){
            allProductsList.addAll(category.getProductList());
        }
        return allProductsList;


    }


}
