package by.issoft.store.xmlreader;

import by.issoft.domain.Product;
import by.issoft.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Comparator {
        Store store;

    public Comparator(Store store) {
        this.store = store;
    }

//what is sortedProductList entity?
    public List<Product> sortedProductList(Map<String, String> comparatorConfig){

        //what method should be applied below? I don't see method getAllProductsList() in store Class.
        // I've stopped here and can't proceed with line 38.
        // Also trying to figure out where to implement Comparator interface. Should that be a Store class?
        List<Product> allProductList = store.addCategory();

        List<String> allKeys = new ArrayList<>();
        List<String> allValues = new ArrayList<>();

        //what is entry?
        for (Map.Entry<String, String> entry: comparatorConfig.entrySet() ){
            allKeys.add(entry.getKey());
            allValues.add(entry.getValue());
        }

        //why -1?
        for (int i = comparatorConfig.size() - 1; i >=0; i--) {

            switch (allKeys.get(i)){
                case "name":
                    if (allValues.get(i).equals("ASC")) {
                        allProductList.sort(Comparator);

                    }
            }
        }


    }


}
