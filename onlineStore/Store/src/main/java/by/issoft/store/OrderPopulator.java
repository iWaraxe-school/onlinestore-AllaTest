package by.issoft.store;

import by.issoft.domain.Product;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OrderPopulator implements Runnable {
    Store store;

    public OrderPopulator(Store store) {
        this.store = store;
    }

    //random value logic
    int minVal = 1;
    int maxVal = 30;
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    int randomNumber = threadLocalRandom.nextInt(minVal, maxVal + 1);
    //Question: It is better to move this logic out of this Class to the separate one?


    @Override
    public void run() {
        List<Product> allProductsList = store.getAllProductsList();
        //update 18 line to select random product
        Product product = allProductsList.get(randomNumber);
        store.addProduct(product);
        Thread.sleep(7000);
        //populating the purchased product list

        //add time


    }
}
