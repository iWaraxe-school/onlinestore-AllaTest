package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StoreHelper {
    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

    public static Set<Category> getCategories() { //Set generic
        Reflections reflections = new Reflections("by.issoft.domain.categories");

        Set<Category> categories = new HashSet<Category>();
        //Set<Class<? extends Category>> subTypesOf = reflections.getSubTypesOf(Category.class);

        for (Class reflectedCategory : reflections.getSubTypesOf(Category.class)) {
            try {
                Constructor constructor = reflectedCategory.getConstructor();
                Object o = constructor.newInstance();
                Category category = (Category) o;
                categories.add(category);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
            return categories;
        }

            //clarify later
//        Category bikeCategory = new BikeCategory();
//        Category milkCategory = new MilkCategory();
//        Category phoneCategory = new PhoneCategory();
            //asList method adds new values to the list
//        return new HashSet<Category>(Arrays.asList(bikeCategory, milkCategory, phoneCategory));



        public void fillStore () {
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
