package by.issoft.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "****";

    Connection conn;

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
            Connection conn = null;
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Successfully connected!");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //STEP 3: Execute a query
    public void createTables() {

        try{
        Statement stmt = null;
        System.out.println("Creating table in given database...");
        stmt = conn.createStatement();
        String sql = "CREATE TABLE   CATEGORY " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        String sql2 = "CREATE TABLE   PRODUCT " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " category VARCHAR(255), " +
                " price int, " +
                " rate int, " +
                //check if this statement below works:
                " FOREIGN KEY (category) REFERENCES CATEGORY(name), " +
                " PRIMARY KEY ( id ))";
        stmt.executeUpdate(sql);
        System.out.println("Created table CATEGORY in given database...");
        stmt.executeUpdate(sql2);
        System.out.println("Created table PRODUCT in given database...");

// STEP 4: Clean-up environment
        stmt.close();
        conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
//            try{
//
//                if(stmt!=null) stmt.close();
//            } catch(SQLException se2) {
//            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
    }
}


