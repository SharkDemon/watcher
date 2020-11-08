package com.simco.watcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.simco.watcher.model.Home;
import com.simco.watcher.model.Observation;
import com.simco.watcher.model.Vehicle;
import com.simco.watcher.service.DummyDataService;
import com.simco.watcher.service.ImageService;

@Controller
@SessionAttributes({"homes", "vehicles", "observations"})
public class BaseController {

    @Autowired
    protected DummyDataService dataService;
    @Autowired
    protected ImageService imageService;

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

    // keep the list of Observation objects in the session
    @ModelAttribute("observations")
    public List<Observation> observationsList() {
        return null;
    }

}
