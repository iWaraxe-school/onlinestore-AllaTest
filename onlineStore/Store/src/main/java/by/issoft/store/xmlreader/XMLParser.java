package by.issoft.store.xmlreader;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.helpers.*;


import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.w3c.dom.Node.ELEMENT_NODE;

public class XMLParser {


    public Map<String, String> getXMLEntities() throws ParserConfigurationException, IOException, SAXException {

        String sortTag = "sort";
        Map<String, String> listOfElements = new LinkedHashMap<>();
        String filePath = "/Users/allakashevarova/IdeaProjects/OnlineStoreAlla/onlineStore/Store/src/main/resources/xml_newconfig.xml";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(filePath);

        NodeList elementsByTagName = doc.getElementsByTagName(sortTag);
        Node node = elementsByTagName.item(0);

        NodeList childNodes = node.getChildNodes();


        Element elementary;
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i).getNodeType() == ELEMENT_NODE) {
                elementary = (Element) childNodes.item(i);

                String key = elementary.getTagName().toLowerCase(Locale.ROOT);
                String value = elementary.getTextContent().toUpperCase(Locale.ROOT);

                listOfElements.put(key, value);
            }
        }
        return listOfElements;

    }

}
