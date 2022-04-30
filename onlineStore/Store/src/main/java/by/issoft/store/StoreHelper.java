package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    public static Set<Category> getCategories(){ //Set generic
        Reflections reflections = new Reflections();
        Set<Category> categories = new HashSet<Category>();
//написала этот код с помощью коллег и информации на stackoverflow.
//Но все еще не разобралась, как правильною
        for(Class reflectedCategory: reflections.getSubTypesOf(Category.class)) {
            categories.add(reflectedCategory.newInstance());
        }

        return categories;

        //clarify later
//        Category bikeCategory = new BikeCategory();
//        Category milkCategory = new MilkCategory();
//        Category phoneCategory = new PhoneCategory();
        //asList method adds new values to the list
//        return new HashSet<Category>(Arrays.asList(bikeCategory, milkCategory, phoneCategory));
    }



    public void fillStore(){
        RandomStorePopulator populator = new RandomStorePopulator();
        Set<Category> categories = getCategories(); //creation of local variable
        for(Category category: categories){
            store.addCategory(category);
            for(int i = 0; i < 10; i++){
                Product product = new Product(
                        populator.getName(category.getName()),
                        populator.getPrice(),
                        populator.getRate());
                category.addProduct(product);
            }
        }
    }


}
