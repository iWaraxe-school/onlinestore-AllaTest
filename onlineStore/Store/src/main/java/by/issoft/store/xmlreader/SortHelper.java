package by.issoft.store.xmlreader;

import by.issoft.domain.Product;
import by.issoft.store.Store;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortHelper {
    Store store;

    public SortHelper(Store store) {

        this.store = store;
    }

    //what is sortedProductList entity?
    public List<Product> sortedProductList(Map<String, String> mapFromXML) {


        List<Product> allProductList = store.getAllProductsList();

        List<String> allKeys = new ArrayList<>();
        List<String> allValues = new ArrayList<>();


        for (Map.Entry<String, String> entry : mapFromXML.entrySet()) {
            allKeys.add(entry.getKey());
            allValues.add(entry.getValue());
        }


        for (int i = mapFromXML.size() - 1; i >= 0; i--) {

            switch (allKeys.get(i)) {
                case "name":
                    if (allValues.get(i).equals("ASC")) {
                        allProductList.sort(Comparator.comparing(Product::getName));
                    } else {
                        allProductList.sort(Comparator.comparing(Product::getName).reversed());
                    }
                    break;

                case "price":
                    if (allValues.get(i).equals("ASC")) {
                        allProductList.sort(Comparator.comparing(Product::getPrice));
                    } else {
                        allProductList.sort(Comparator.comparing(Product::getPrice).reversed());
                    }
                    break;

                case "rate":
                    if (allValues.get(i).equals("ASC")) {
                        allProductList.sort(Comparator.comparing(Product::getRate));
                    } else {
                        allProductList.sort(Comparator.comparing(Product::getRate).reversed());
                    }
                    break;
            }
        }
        return allProductList;
    }

    public void sortXML() throws ParserConfigurationException, IOException, SAXException {
        XMLParser parser = new XMLParser();
        Map<String, String> configMap = parser.getXMLEntities();
        System.out.println(configMap);
        List<Product> productsSortedByXML = sortedProductList(configMap);
        System.out.println("-------------------------------");
        System.out.println("SORT PRODUCTS SEQUENTIAL RIGHT");
        System.out.println("-------------------------------");
        for (Product product: productsSortedByXML) {
            System.out.println(product);
        }

    }

    public void sortTop5 (){
        List<Product> allProductList = store.getAllProductsList();
        allProductList.sort(Comparator.comparing(Product::getPrice).reversed());


        for (Product product: allProductList.subList(0,5)){
            System.out.println(product);
        }


    }
}

