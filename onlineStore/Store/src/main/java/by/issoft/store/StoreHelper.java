package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    public static Set<Category> getCategories() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException { //Set generic
        Reflections reflections = new Reflections();
        Set<Category> categories = new HashSet<Category>();

        for (Class<? extends Category> reflectedCategory : reflections.getSubTypesOf(Category.class)) {
            categories.add(reflectedCategory.getConstructor().newInstance());
        }

        return categories;

    }

    public void fillStore() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        RandomStorePopulator populator = new RandomStorePopulator();
        Set<Category> categories = getCategories(); //creation of local variable
        for (Category category : categories) {
            store.addCategory(category);
            for (int i = 0; i < 10; i++) {
                Product product = new Product(
                        populator.getName(category.getName()),
                        populator.getPrice(),
                        populator.getRate());
                category.addProduct(product);
            }
        }
    }


}
