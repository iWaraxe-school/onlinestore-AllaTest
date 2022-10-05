package by.issoft.store.ServerHelpers;

import by.issoft.store.config.Configuration;
import by.issoft.store.config.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServerHelper {

    Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
    static final String CRLF = "\r\n";

    public void startServer(){

        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("/Users/allakashevarova/IdeaProjects/OnlineStoreAlla/onlineStore/consoleApp/src/main/resources/http.json");


        System.out.println("Using Port " + conf.getPort());
        System.out.println("Using WebRoot " + conf.getWebroot());
    }

    public void establishSockets(){

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(conf.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: send the html page to the browser (in learning purposes)

        String html = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>Test Page</h1></body></html>";


        String response =
                "HTTP/1.0 200 OK" + CRLF + //Status Line : HTTP VERSION RESPONSE CODE RESPONSE MESSAGE
                        "Content-Type: text/html" + CRLF +
                        "Date: " + new Date() + CRLF +
                        "Content-Length: " + html.getBytes().length + CRLF + // HEADER
                        CRLF +
                        html +
                        CRLF + CRLF;

        try {
            outputStream.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
