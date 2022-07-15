package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private Store() {

    }

    private static class SingletonHelper{
        private static final Store STORE_INSTANCE = new Store();
    }

    public static Store getInstance(){
        return SingletonHelper.STORE_INSTANCE;
    }

    private List<Category> categoryList = new ArrayList<>();


    //Pattern Singleton
    private static class SingletonHelper() {
        private static final Store STORE_INSTANCE = new Store();
    }

    public static Store getInstance(){
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

    public List<Product> getAllProductsList() {
        List<Product> allProductsList = new ArrayList<>();
        for (Category category : categoryList) {
            allProductsList.addAll(category.getProductList());
        }
        return allProductsList;


    }


}
