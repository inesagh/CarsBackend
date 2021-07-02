package com.example.carsbackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    static Car CAR;
    static String DB_URL = "jdbc:mariadb://localhost:3306/car_db";
    static String USER = "root";
    static String PASS = "??????";

    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            creatingInDB(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void creatingInDB(Connection connection) {
        try{
        Statement statement = connection.createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS car_db");
            statement.execute("use car_db");

            statement.execute("CREATE TABLE IF NOT EXISTS car(id INT NOT NULL UNIQUE AUTO_INCREMENT, name VARCHAR(30), brand VARCHAR (20), doors INT, price VARCHAR(20))");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
