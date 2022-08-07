package by.issoft.store;
import by.issoft.domain.Product;

import by.issoft.domain.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.TimerTask;
@Slf4j
public class OrderCleanupHelper extends TimerTask {

    Store store;

    public OrderCleanupHelper(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        log.info("Thread started");
        List<Product> purchasedProducts = store.getPurchasedProducts();

        //How to add logic to show just the product name in the List before the cleanup?
//        Product product = new Product();
//        List<Product> purchasedProductsNames = purchasedProducts(product.getName());


        System.out.println("List of purchased products before the cleanup: " + purchasedProducts);
        store.cleanPurchasedProducts();



        boolean emptyList = purchasedProducts.isEmpty();
        if (emptyList == true) {
            System.out.println("Cleanup completed. The List of purchased products is empty.");
        } else {
            System.out.println("Something is wrong. The List of purchased products after the cleanup is still full: " + purchasedProducts);
        }

    }


}
