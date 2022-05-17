package by.issoft.consoleApp;

import by.issoft.store.Store;
import by.issoft.store.StoreHelper;

import java.util.ArrayList;
//delete this later
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class consoleApp {

    public static void main(String[] args){




        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.fillStore();
        store.printAllCategoriesAndProducts();


        
    }
}
