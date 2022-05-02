package by.issoft.store;

import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Category> categoryList = new ArrayList<>();


    public void printAllCategoriesAndProducts() {
        for (Category category : categoryList) {
            category.printAllProducts();

        }
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    //Task: use of reflections in order to create instances of child categories
    // and add them into category list. Remember! You should not create
    // categories by “hands” with help of constructors.
    // All child categories have to be created with help of reflections (50%)!



}
