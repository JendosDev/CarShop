package com.vehiclestore.CarShop.repository;

import com.vehiclestore.CarShop.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiclelist",
                                                        "root",
                                                        "Heslo123!");
    Statement statement = connection.createStatement();

    public VehicleRepository() throws SQLException {
    }

    public List<Vehicle> getAll() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicle");

        List<Vehicle> vehicles = new ArrayList<>();
        while (resultSet.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(resultSet.getInt("id"));
            vehicle.setBrand(resultSet.getString("brand"));
            vehicle.setVehicleModel(resultSet.getString("vehicleModel"));
            vehicle.setSPZ(resultSet.getString("SPZ"));
            vehicle.setPrice(resultSet.getBigDecimal("price"));
            vehicle.setYear(resultSet.getInt("year"));
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    public void save(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO vehicle(brand, vehicleModel, price, year) VALUES ('"
                + vehicle.getBrand() + "', '"
                + vehicle.getVehicleModel() + "', '"
                + vehicle.getPrice() + "', '"
                + vehicle.getYear() + "', '";
            statement.executeUpdate(query);
    }

    public Vehicle findById(int id) throws SQLException {
        String query = "SELECT * FROM vehicle WHERE id = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Vehicle vehicle = new Vehicle();
        if (resultSet.next()) {
            vehicle.setId(resultSet.getInt("id"));
            vehicle.setBrand(resultSet.getString("brand"));
            vehicle.setVehicleModel(resultSet.getString("vehicleModel"));
            vehicle.setSPZ(resultSet.getString("SPZ"));
            vehicle.setPrice(resultSet.getBigDecimal("price"));
            vehicle.setYear(resultSet.getInt("year"));
        }
        return vehicle;
    }

    public void deleteById(int id) throws SQLException {
            String query = "DELETE FROM vehicle WHERE id = " + id;
            statement.executeUpdate(query);
    }

    public void update(Vehicle vehicle) throws SQLException {
        String query = "UPDATE vehicle SET "
                + "vehicleModel = '" + vehicle.getVehicleModel() + "', "
                + "SPZ = '" + vehicle.getSPZ() + "', "
                + "price = '" + vehicle.getPrice() + "' WHERE id = " + vehicle.getId();
        statement.executeUpdate(query);
    }
}
