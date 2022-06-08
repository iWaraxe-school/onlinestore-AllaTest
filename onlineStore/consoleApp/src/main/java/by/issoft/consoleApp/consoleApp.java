package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.StoreHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
//delete this later
import java.util.List;

public class consoleApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {




        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.fillStore();
        store.printAllCategoriesAndProducts();
        
    }
}
