package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Store {
    private List<Category> categoryList = new ArrayList<>();
    private List<Product> purchasedProducts = new CopyOnWriteArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void cleanPurchasedProducts() {
        purchasedProducts.clear();
    }

    //Pattern Singleton
    private static class SingletonHelper {
        private static final Store STORE_INSTANCE = new Store();
    }

    public static Store getInstance() {
        return SingletonHelper.STORE_INSTANCE;
    }

    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();
        }
    }

    public void addCategory(Category category) {
        categoryList.add(category);
    }

    //is that a good method name?
    public void addPurchasedProduct(Product product) {
        purchasedProducts.add(product);
    }


    public List<Product> getAllProductsList() {
        List<Product> allProductsList = new ArrayList<>();
        for (Category category : categoryList) {
            allProductsList.addAll(category.getProductList());
        }
        return allProductsList;
    }
}
