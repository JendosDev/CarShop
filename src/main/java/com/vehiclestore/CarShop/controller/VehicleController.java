package com.vehiclestore.CarShop.controller;

import com.vehiclestore.CarShop.model.Vehicle;
import com.vehiclestore.CarShop.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class VehicleController {
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping(value = "/")
    public String homePage(Model model) throws SQLException {
        model.addAttribute("allcarlist", vehicleService.getAllVehicles());
        return "index";
    }

    @GetMapping(value = "/add")
    public String addNewVehicle(Model model) throws SQLException {
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "newVehicle";
    }

    @PostMapping(value = "/save")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) throws SQLException {
        vehicleService.save(vehicle);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateVehicle(@ModelAttribute("vehicle") Vehicle vehicle) throws SQLException {
        vehicleService.update(vehicle);
        return "redirect:/";
    }

    @GetMapping(value = "/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) throws SQLException {
        Vehicle updated = vehicleService.updateVehicle(id, model);
        return "updatevehicle";
    }

    @GetMapping(value = "/delete-vehicle/{id}")
    public String deleteVehicle(@PathVariable(value = "id") int id) throws SQLException {
        vehicleService.deleteById(id);
        return "redirect:/";
    }
}
