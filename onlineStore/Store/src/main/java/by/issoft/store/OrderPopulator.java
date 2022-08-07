package by.issoft.store;

import by.issoft.domain.Product;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
public class OrderPopulator implements Runnable {
    Store store;

    public OrderPopulator(Store store) {
        this.store = store;
    }


    int minVal = 1;
    int maxVal = 30;
    ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    //int randomNumber = threadLocalRandom.nextInt(minVal, maxVal + 1);


    @Override
    @SneakyThrows


    public void run() {

        //Question: Why I get 2 tread logs in a row and then 2 executions of System.out.println("The following product has been added: " + product.getName()); ?
        Thread thread = new Thread();
        log.info("Thread " + thread.getName() + " has been started");

        List<Product> allProductsList = store.getAllProductsList();
        Product product = allProductsList.get(threadLocalRandom.nextInt(allProductsList.size()));
        store.addPurchasedProduct(product);
        System.out.println("The following product has been added: "+ product.getName());
        Thread.sleep(7000);
        log.info("Thread " + thread.getName() + " has been finished");


    }
}
