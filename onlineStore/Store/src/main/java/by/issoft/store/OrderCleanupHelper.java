package by.issoft.store;


import java.util.TimerTask;

public class OrderCleanupHelper extends TimerTask {

    Store store;

    public OrderCleanupHelper(Store store) {
        this.store = store;
    }


    @Override
    public static void run() {
        //is that correct way of getting purchasedProducts list?
        store.getPurchasedProducts().clear();
    }
}
