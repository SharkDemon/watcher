package com.simco.watcher.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.simco.watcher.model.Vehicle;
import com.simco.watcher.service.DummyDataService;

@Controller
@SessionAttributes({"vehicles"})
public class VehiclesController {

    private static final Logger logger = LoggerFactory.getLogger(VehiclesController.class);

    @Autowired
    private DummyDataService dataService;

    // keep the list of Vehicle objects in the session
    @ModelAttribute("vehicles")
    public List<Vehicle> vehiclesList() {
        return null;
    }

    @GetMapping("/vehicles")
    public String showVehicles(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            Model model) {

        // just in case we visit this page first, ensure vehicles list
        // has been initialized and populated with dummy data
        if (null == vehicles)
            vehicles = dataService.getAllVehicles();

        logger.info("showVehicles invoked - returning vehicles=[{}]",
                vehicles.size()
                );

        // add session variables
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

}
