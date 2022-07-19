package by.issoft.consoleApp.command;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class QuitCommand implements Command{

    boolean flag = true;

    public QuitCommand(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void execute() throws ParserConfigurationException, IOException, SAXException {
        flag = false;
    }
}
