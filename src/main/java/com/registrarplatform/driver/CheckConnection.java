package com.registrarplatform.driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckConnection {
    public static void main(String[] args) {
        /*
         *  Code to test connection with PostgreSQL DB
         * */

        String jdbcURL = "jdbc:postgresql://localhost:5432/testdb";
        String user = "postgres";
        String password = "postgres";

        try {
            System.out.println("Connecting to database: " + jdbcURL);
            Connection connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Successfully Connected to " + connection.toString());
        } catch (Exception e) {
            System.out.println("Connection Failed..");
            System.out.println(e.getMessage());
        }
        System.out.println( "Hello World!" );
    }
}
