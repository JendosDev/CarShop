package com.vehiclestore.CarShop.service;

import com.vehiclestore.CarShop.model.Vehicle;
import com.vehiclestore.CarShop.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.SQLException;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehRepo;

    public VehicleServiceImpl(VehicleRepository vehRepo) {
        this.vehRepo = vehRepo;
    }

    @Override
    public List<Vehicle> getAllVehicles() throws SQLException {
        return vehRepo.getAll();
    }

    @Override
    public void save(Vehicle vehicle) throws SQLException {
        vehRepo.save(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) throws SQLException {
        vehRepo.update(vehicle);
    }

    @Override
    public void deleteById(int id) throws SQLException {
        vehRepo.deleteById(id);
    }

    @Override
    public Vehicle updateVehicle(int id, Model model) throws SQLException {
        Vehicle vehicle = vehRepo.findById(id);
        return vehicle;
    }
}
