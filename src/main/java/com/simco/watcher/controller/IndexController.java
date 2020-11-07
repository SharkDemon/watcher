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

import com.simco.watcher.model.Home;
import com.simco.watcher.model.Vehicle;
import com.simco.watcher.service.DummyDataService;
import com.simco.watcher.service.ImageService;

@Controller
@SessionAttributes({"homes", "vehicles"})
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private DummyDataService dataService;
    @Autowired
    private ImageService imageService;

    // keep the list of Home objects in the session
    @ModelAttribute("homes")
    public List<Home> homesList() {
        return null;
    }

    // keep the list of Vehicle objects in the session
    @ModelAttribute("vehicles")
    public List<Vehicle> vehiclesList() {
        return null;
    }

    @GetMapping("/")
    public String showIndex(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            Model model) {

        // on the first visit to index page, ensure the homes and vehicles lists
        // have been initialized and populated with dummy data
        if (null == homes)
            homes = dataService.getAllHomes();
        if (null == vehicles)
            vehicles = dataService.getAllVehicles();

        String homesCardImagePath = imageService.getRandomHomeCardImage();
        String vehiclesCardImagePath = imageService.getRandomVehicleCardImage();
        String observeCardImagePath = imageService.getRandomObserveCardImage();

        logger.info("showIndex invoked - returning homes=[{}], vehicles=[{}], homesImage=[{}], vehiclesImage=[{}], observeImage=[{}]",
                homes.size(),
                vehicles.size(),
                homesCardImagePath,
                vehiclesCardImagePath,
                observeCardImagePath
                );

        // add session variables
        model.addAttribute("homes", homes);
        model.addAttribute("vehicles", vehicles);
        // add data necessary to render view
        model.addAttribute("homesCardImagePath", homesCardImagePath);
        model.addAttribute("vehiclesCardImagePath", vehiclesCardImagePath);
        model.addAttribute("observeCardImagePath", observeCardImagePath);
        return "index";
    }

}
