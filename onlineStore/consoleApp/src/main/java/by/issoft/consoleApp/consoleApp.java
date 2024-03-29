package by.issoft.consoleApp;

import by.issoft.consoleApp.command.QuitCommand;
import by.issoft.consoleApp.command.SortCommand;
import by.issoft.consoleApp.command.Top5Command;
import by.issoft.domain.Category;
import by.issoft.store.*;
import by.issoft.store.config.Configuration;
import by.issoft.store.config.ConfigurationManager;
import by.issoft.store.http.HttpClient;
import by.issoft.store.http.Server;
import by.issoft.store.xmlreader.SortHelper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.util.Timer;

public class consoleApp {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException, URISyntaxException {


        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper(store);
        //storeHelper.fillStore();
        //store.printAllCategoriesAndProducts();
        Server server = new Server();
        server.createServer();
        System.in.read();
        HttpClient client = new HttpClient();



        //DB operations:
//        DatabaseHelper databaseHelper = new DatabaseHelper();
//        databaseHelper.registerDriver();
//        databaseHelper.openConnection();
//        databaseHelper.clearDatabase();
//        databaseHelper.createTables();
//        //Looks like the system does not want to execute this method at all:
//        databaseHelper.populateDatabase();
//        databaseHelper.printProductsFromDatabase();
//
/**
        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("/Users/allakashevarova/IdeaProjects/OnlineStoreAlla/onlineStore/consoleApp/src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using Port " + conf.getPort());
        System.out.println("Using WebRoot " + conf.getWebroot());

        ServerSocket serverSocket = new ServerSocket(conf.getPort());
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        // TODO: send the html page to the browser (in learning purposes)

        String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>Test Page</h1></body></html>";

        final String CRLF = "\r\n";

        String response =
                "HTTP/1.1 200 OK" + CRLF + //Status Line : HTTP VERSION RESPONSE CODE RESPONSE MESSAGE
                "Content-Length: " + html.getBytes().length + CRLF + // HEADER
                        CRLF +
                        html +
                        CRLF + CRLF;

        outputStream.write(response.getBytes());


        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();*/

        //Start server
//        ServerHelper serverHelper = new ServerHelper();
//        serverHelper.startServer();




        SortHelper sortHelper = new SortHelper(store);
        OrderPopulator orderPopulator = new OrderPopulator(store);


//        System.out.println("Enter some of the following command: Sort/Top5/Order or Quit:");

//Interactive: Scanner; BufferedReader
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        boolean flag = true;

        //Timer timer = new Timer();
        //timer.schedule(new OrderCleanupHelper(store), 60000, 120000);
        //add logging on cleanup (and show list of purchases before Purchase and after)


//        while (flag) {
//            String command = reader.readLine();
//
//
//            switch (command) {
//                case "Sort":
//                    new SortCommand(sortHelper).execute();
//                    break;
//                case "Quit":
//                    new QuitCommand(flag).execute();
//                    //timer.cancel();
//                    System.out.println("Execution has been stopped");
//                    break;
//                case "Top5":
//                    new Top5Command(sortHelper).execute();
//                    break;
//                case "Order":
//                    new Thread(orderPopulator).start();
//                    break;
//                default:
//                    System.out.println("This command is not recognized");
//            }
//
//        }

    }
}
