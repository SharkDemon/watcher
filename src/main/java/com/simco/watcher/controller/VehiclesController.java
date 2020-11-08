package com.simco.watcher.controller;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simco.watcher.model.State;
import com.simco.watcher.model.Vehicle;

@Controller
public class VehiclesController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(VehiclesController.class);

    @GetMapping("/vehicles")
    public String showVehicles(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            Model model) {

        logger.info("showVehicles invoked - returning vehicles=[{}]", vehicles.size());

        vehicles = vehicles.stream()
                .sorted(Comparator.comparing(Vehicle::getPlateNumber).thenComparing(Vehicle::getPlateState))
                .collect(Collectors.toList());

        // add session variables
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }

    @GetMapping("/vehicles/edit/{vehicleId}")
    public String showEditVehicle(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @PathVariable UUID vehicleId,
            ModelMap model) {

        logger.info("showEditVehicle invoked - vehicleId=[{}]", vehicleId);

        // get the vehicle matching on UUID
        Vehicle vehicleToEdit = vehicles.stream()
                .filter(cc -> cc.getId().equals(vehicleId))
                .collect(Collectors.toList())
                .get(0); // let's assume a find

        // add session variables
        model.addAttribute("vehicles", vehicles);
        // add data necessary to render view
        model.addAttribute("vehicleToEdit", vehicleToEdit);
        return "editVehicle";
    }

    @PostMapping("/vehicles/edit/{vehicleId}")
    public ModelAndView editVehicle(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @ModelAttribute Vehicle editedVehicle,
            @PathVariable UUID vehicleId,
            ModelMap model) {

        logger.info("editVehicle invoked - id=[{}]",
                vehicleId);

        // find the existing Home so that we can update its properties
        int indexOfInterest = 0;
        for (Vehicle v : vehicles) {
            if (v.getId().equals(vehicleId))
                break;
            indexOfInterest++;
        }
        vehicles.get(indexOfInterest).setColor(editedVehicle.getColor());
        vehicles.get(indexOfInterest).setMake(editedVehicle.getMake());
        vehicles.get(indexOfInterest).setModel(editedVehicle.getModel());
        vehicles.get(indexOfInterest).setPlateNumber(editedVehicle.getPlateNumber());
        vehicles.get(indexOfInterest).setPlateState(editedVehicle.getPlateState());

        // add session variables
        model.addAttribute("vehicles", vehicles);
        return new ModelAndView("redirect:/vehicles", model);
    }

    @GetMapping("/vehicles/remove/{vehicleId}")
    public ModelAndView removeVehicle(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @PathVariable UUID vehicleId,
            ModelMap model) {

        logger.info("removeVehicle invoked - vehicleId=[{}]", vehicleId);

        // remove vehicles (should be just one) matching on UUID
        vehicles = vehicles.stream()
                .filter(v -> !v.getId().equals(vehicleId))
                .collect(Collectors.toList());

        // add session variables
        model.addAttribute("vehicles", vehicles);
        return new ModelAndView("redirect:/vehicles", model);
    }

    @GetMapping("/vehicles/add")
    public String showAddVehicle(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            Model model) {

        logger.info("showAddVehicle invoked");

        Vehicle newVehicle = Vehicle.builder()
                .plateState(State.TX)
                .build();

        // add session variables
        model.addAttribute("vehicles", vehicles);
        // add data necessary to render view
        model.addAttribute("newVehicle", newVehicle);
        return "addVehicle";
    }

    @PostMapping("/vehicles/add")
    public ModelAndView addVehicle(
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @ModelAttribute Vehicle newVehicle,
            BindingResult errors,
            ModelMap model) {

        // force the license plate number into upper case
        newVehicle.setPlateNumber(newVehicle.getPlateNumber().toUpperCase());

        logger.info("addVehicle invoked - color=[{}], make=[{}], model=[{}], plateNumber=[{}], plateState=[{}]",
                newVehicle.getColor().getDisplayName(),
                newVehicle.getMake(),
                newVehicle.getModel(),
                newVehicle.getPlateNumber(),
                newVehicle.getPlateState().getAbbreviation());

        // assign ID to the new Vehicle and add it to our collection
        newVehicle.setId(UUID.randomUUID());
        vehicles.add(newVehicle);

        // add session variables
        model.addAttribute("vehicles", vehicles);
        return new ModelAndView("redirect:/vehicles", model);
    }

}
