package com.simco.watcher.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.simco.watcher.model.Home;
import com.simco.watcher.model.Observation;
import com.simco.watcher.model.Vehicle;

@Controller
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String showIndex(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @ModelAttribute("observations") List<Observation> observations,
            Model model) {

        // on the first visit to index page, ensure the homes, vehicles, and
        // observations lists have been initialized and populated with dummy
        // data
        if (null == homes)
            homes = dataService.getAllHomes();
        if (null == vehicles)
            vehicles = dataService.getAllVehicles();
        if (null == observations)
            observations = dataService.getAllObservations();

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
        model.addAttribute("observations", observations);
        // add data necessary to render view
        model.addAttribute("homesCardImagePath", homesCardImagePath);
        model.addAttribute("vehiclesCardImagePath", vehiclesCardImagePath);
        model.addAttribute("observeCardImagePath", observeCardImagePath);
        return "index";
    }

}
