package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.StoreHelper;
import by.issoft.store.xmlreader.SortHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
//delete this later
import java.util.List;

public class consoleApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

// Is that correct usage of Singleton pattern? In line 17 I wanted to create a new Store object.
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.fillStore();
        store.printAllCategoriesAndProducts();

        //not sure if I had to print sorted List here


        SortHelper sorthelper = new SortHelper();
        System.out.println(sorthelper.sortedProductList().subList(0, 4));


    }
}
