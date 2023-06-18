package com.vehiclestore.CarShop.service;

import com.vehiclestore.CarShop.model.Vehicle;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> getAllVehicles() throws SQLException;
    void save(Vehicle vehicle) throws SQLException;
    void update(Vehicle vehicle) throws SQLException;
    void deleteById(int id) throws SQLException;
    Vehicle updateVehicle(int id, Model model) throws SQLException;
}
