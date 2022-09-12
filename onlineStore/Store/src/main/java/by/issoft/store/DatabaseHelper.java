package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.Product;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DatabaseHelper {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/Online_Store?user=root";


    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    //create constants
    static Connection CONNECTION = null;
    static Statement STATEMENT = null;
    static ResultSet RESULTSET = null;

    // STEP 1: Register JDBC driver
    public void registerDriver() {
        try {
            System.out.println("Registering driver...");
            Class.forName(JDBC_DRIVER);
        } catch (Exception ex) {
            // handle the error
        }
    }

    //STEP 2: Open a connection
    public void openConnection() {

        try {
            System.out.println("Connecting to database...");
            CONNECTION = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Successfully connected!");
            STATEMENT = CONNECTION.createStatement();

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public void clearDatabase() {
        String query1 = "DROP table if exists CATEGORIES";
        String query2 = "DROP table if exists PRODUCTS";
        try {
            STATEMENT.executeUpdate(query2);
            STATEMENT.executeUpdate(query1);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    //STEP 3: Execute a query
    public void createTables() {

        try {
            System.out.println("Creating table in given database...");
            //stmt = conn.createStatement();
            String sql = "CREATE TABLE   CATEGORIES " +
                    "(id INTEGER AUTO_INCREMENT not NULL, " +
                    " name VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";
            String sql2 = "CREATE TABLE   PRODUCTS " +
                    "(id INTEGER AUTO_INCREMENT not NULL, " +
                    " name VARCHAR(255), " +
                    " category_id int, " +
                    " price int, " +
                    " rate int, " +
                    //check if this statement below works:
                    " FOREIGN KEY (category_id) REFERENCES CATEGORIES(id), " +
                    " PRIMARY KEY ( id ))";
            STATEMENT.executeUpdate(sql);
            System.out.println("Created table CATEGORIES in given database...");
            STATEMENT.executeUpdate(sql2);
            System.out.println("Created table PRODUCTS in given database...");

// STEP 4: Clean-up environment

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (CONNECTION != null) CONNECTION.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }

    public void populateDatabase() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println("Connecting to database...");
        try {
            CONNECTION = DriverManager.getConnection(DB_URL, USER, PASS);
            STATEMENT = CONNECTION.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully connected!");

        RandomStorePopulator populator = new RandomStorePopulator();
        List<Category> categoryList = Store.getInstance().getCategoryList();

        //populate BD with categories
        System.out.println(categoryList);
        for (Category category : categoryList) {
            try {
                System.out.printf("Insert" + category.getName() + "into database");

                String sqlCategories = "INSERT INTO CATEGORIES(name) VALUE(?)";
                PreparedStatement insertCategories = CONNECTION.prepareStatement(sqlCategories);
                insertCategories.setString(1, category.getName());
                insertCategories.execute();
                System.out.println(insertCategories);

                String sqlFindCategory = "SELECT ID FROM CATEGORIES WHERE name = ?";
                PreparedStatement findCategoryID = CONNECTION.prepareStatement(sqlFindCategory);
                findCategoryID.setString(1, category.getName());
                RESULTSET = findCategoryID.executeQuery();

                int id = 0;
                while (RESULTSET.next()) {
                    id = RESULTSET.getInt("ID");
                }

                Random randomNumber = new Random();

                for (int i = 0; i < randomNumber.nextInt(10) + 1; i++) {
                    String sqlProducts = "INSERT INTO PRODUCTS(name, category_id, price, rate) VALUE(?,?,?,?)";
                    PreparedStatement insertProducts = CONNECTION.prepareStatement(sqlProducts);
                    insertProducts.setString(1, populator.getName(category.getName()));
                    insertProducts.setInt(2, id);
                    insertProducts.setDouble(3, populator.getPrice());
                    insertProducts.setDouble(4, populator.getRate());
                    System.out.println(insertProducts);
                    insertProducts.execute();
                    System.out.println("Product has been added");

                }
            } catch (Exception e) {
                System.err.println("Got an exception!");
                // printStackTrace method
                // prints line numbers + call stack
                e.printStackTrace();
                // Prints what exception has been thrown
                System.out.println(e);
            }
        }
        try {
            STATEMENT.close();
            CONNECTION.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //check why there are 6 CATEGORIES instead of 3. Reflections(?)
    //print all products and categories

    //Print products
    public void printProductsFromDatabase() {

        System.out.println("Connecting to database...");
        try {
            CONNECTION = DriverManager.getConnection(DB_URL, USER, PASS);
            STATEMENT = CONNECTION.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully connected!");

        String sqlGetProducts = "SELECT p.name, c.name, p.price, p.rate FROM PRODUCTS p JOIN CATEGORIES c ON c.id = p.category_id";
        try {
            PreparedStatement getProducts = CONNECTION.prepareStatement(sqlGetProducts);
            RESULTSET = getProducts.executeQuery();

            while (RESULTSET.next()) {
                String name = RESULTSET.getString(1);
                String categoryName = RESULTSET.getString(2);
                String price = RESULTSET.getString(3);
                String rate = RESULTSET.getString(4);
                System.out.println("Product Name: " + name + " | " + "Category: " + categoryName + " | " + "Price: " + price + " | " + "Rate: " + rate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            STATEMENT.close();
            CONNECTION.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


