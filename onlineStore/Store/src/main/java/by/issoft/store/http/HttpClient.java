package by.issoft.store.http;

import by.issoft.domain.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;

public class HttpClient {

    java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
    HttpURLConnection connection;

    public HttpClient() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("http://localhost:8080/categories"))
                //.header("Authorization", getBasicAuthenticationHeader("user", "password"))
                .build();



        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HttpHeaders responseHeaders = response.headers();
        System.out.println(response.body());

        // TODO resolve the issue below:
        logger.info("Status using headers: {}", response.statusCode());
    }

    public HttpURLConnection getConnection(String file, String method) {
        try {
            URL address = new URL("http", "localhost", 8080, file);
            String encoding = Base64.getEncoder().encodeToString(("user:password").getBytes("UTF-8"));
            connection = (HttpURLConnection) address.openConnection();
            connection.setRequestMethod(method);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error to get connection. URL problem", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error to get connection. Encoding problem", e);
        } catch (IOException e) {
            throw new RuntimeException("Error to get connection", e);
        }
        return connection;
    }
    // TODO resolve the issue below:
    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class.getName());

    //authentication
    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }




    public void addToCart(List<Category> categories, int categoryId, int productId) {
        connection = getConnection("/cart", "POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setDoOutput(true);
        try {
            OutputStream os = connection.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            byte[] postData = mapper.writeValueAsBytes(categories.get(categoryId).getProductList().get(productId));
            os.write(postData);
        } catch (IOException e) {
            throw new RuntimeException("Error to add to cart", e);
        }

    }


}
