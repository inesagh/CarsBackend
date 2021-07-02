package com.example.carsbackend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    public static void create(Car car){
        Connection connection = DAO.connection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car(name, brand, doors, price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setInt(3, car.getDoors());
            preparedStatement.setString(4, car.getPrice());
            ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static List<Car> readAll(){
        Connection connection = DAO.connection();
        List<Car> carList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM car");
            while(resultSet.next()){
                Car car = new Car(resultSet.getString("name"), resultSet.getString("brand"), resultSet.getInt("doors"), resultSet.getString("price"));
                carList.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return carList;
    }
    public static Car readById(int id){
        Connection connection = DAO.connection();
        Car car = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                car = new Car(resultSet.getString("name"), resultSet.getString("brand"), resultSet.getInt("doors"), resultSet.getString("price"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return car;
    }

    public static Car update(int id, Car car){
        Car updatedCar = null;
            Connection connection = DAO.connection();
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE car SET name = ?, brand = ?, doors = ?, price = ? WHERE id = ?")) {
                preparedStatement.setString(1, car.getName());
                preparedStatement.setString(2, car.getBrand());
                preparedStatement.setInt(3, car.getDoors());
                preparedStatement.setString(4, car.getPrice());
                preparedStatement.setInt(5, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                updatedCar = readById(id);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return updatedCar;
    }

    public static void delete(int id){
        Connection connection = DAO.connection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
