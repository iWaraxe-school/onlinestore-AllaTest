package by.issoft.store.xmlreader;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public class ReadXML {
    public static void main(String[] args) {

        XMLParser xmlParser = new XMLParser();
        try{
            final Map<String, String> xmlEntities = xmlParser.getXMLEntities();
            System.out.println(xmlEntities);
        }catch (ParserConfigurationException | IOException | SAXException  e) {
            e.printStackTrace();
        }
    }
}
