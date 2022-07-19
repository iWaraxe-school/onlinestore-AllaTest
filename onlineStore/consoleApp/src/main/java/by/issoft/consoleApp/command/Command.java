package by.issoft.consoleApp.command;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Command {
    void execute() throws ParserConfigurationException, IOException, SAXException;
}
