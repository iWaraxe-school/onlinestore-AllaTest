package by.issoft.consoleApp;

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

public class consoleApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException {




        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        storeHelper.fillStore();
        store.printAllCategoriesAndProducts();

        //not sure if I had to print sorted List here


        SortHelper sorthelper = new SortHelper(store);




        System.out.println("Enter some of the following command: Sort/Top5 or Quit");

//Interactive: Scanner; BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        while (flag) {
            String command = reader.readLine();


            switch (command) {
                case "Sort":
                    sorthelper.sortXML();
                    break;
                case "Quit":
                    flag = false;
                    break;
                case "Top5":

                    sorthelper.sortTop5();

                    break;
                default:
                    System.out.println("This command is not recognized");
            }

        }

    }
}
