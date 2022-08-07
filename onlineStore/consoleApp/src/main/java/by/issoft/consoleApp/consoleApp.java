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


        System.out.println("Enter some of the following command: Sort/Top5/Order or Quit:");

//Interactive: Scanner; BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        Timer timer = new Timer();
        timer.schedule(new OrderCleanupHelper(store), 60000, 120000);
        //add logging on cleanup (and show list of purchases before Purchase and after)



        while (flag) {
            String command = reader.readLine();


            switch (command) {
                case "Sort":
                    new SortCommand(sortHelper).execute();
                    break;
                case "Quit":
                    new QuitCommand(flag).execute();
                    timer.cancel();
                    System.out.println("Execution has been stopped");
                    break;
                case "Top5":
                    new Top5Command(sortHelper).execute();
                    break;
                case "Order":
                    //System.out.println("Divider1");

                    new Thread(orderPopulator).start();
                    //System.out.println("Divider2");
                    new Thread(orderPopulator).start();
                    //System.out.println("Divider3");

                    //add logging - what product and thread

                    break;
                default:
                    System.out.println("This command is not recognized");
            }

        }

    }
}
