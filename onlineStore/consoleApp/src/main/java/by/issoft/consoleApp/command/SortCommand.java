package by.issoft.consoleApp.command;

import by.issoft.store.xmlreader.SortHelper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class SortCommand implements Command{
    SortHelper sortHelper;

    public SortCommand(SortHelper sortHelper) {
        this.sortHelper = sortHelper;
    }

    @Override
    public void execute() throws ParserConfigurationException, IOException, SAXException {
        sortHelper.sortXML();

    }
}
