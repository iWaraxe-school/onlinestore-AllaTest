package by.issoft.consoleApp;

import by.issoft.consoleApp.command.QuitCommand;
import by.issoft.consoleApp.command.SortCommand;
import by.issoft.consoleApp.command.Top5Command;
import by.issoft.domain.Product;
import by.issoft.store.OrderCleanupHelper;
import by.issoft.store.OrderPopulator;
import by.issoft.store.Store;
import by.issoft.store.StoreHelper;
import by.issoft.store.xmlreader.SortHelper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
//delete this later
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class consoleApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException {


        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.fillStore();
        store.printAllCategoriesAndProducts();

        //not sure if I had to print sorted List here


        SortHelper sortHelper = new SortHelper(store);
        OrderPopulator orderPopulator = new OrderPopulator(store);


        System.out.println("Enter some of the following command: Sort/Top5 or Quit");

//Interactive: Scanner; BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        Timer timer = new Timer;
        TimerTask orderCleanupHelper = TimerTask.run();
        //I don't know where exactly to use this timer and what exactly method to use?
        timer.schedule(orderCleanupHelper, 60000, 120000);
        timer.schedule(orderCleanupHelper,120000);


        while (flag) {
            String command = reader.readLine();


            switch (command) {
                case "Sort":
                    new SortCommand(sortHelper).execute();
                    break;
                case "Quit":
                    new QuitCommand(flag).execute();
                    break;
                case "Top5":
                    new Top5Command(sortHelper).execute();
                    break;
                case "Order":
                    new Thread(orderPopulator).start();

                    break;
                default:
                    System.out.println("This command is not recognized");
            }

        }

    }
}
