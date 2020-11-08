package com.simco.watcher.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.simco.watcher.model.ContractorStatus;
import com.simco.watcher.model.GarageStatus;
import com.simco.watcher.model.Home;
import com.simco.watcher.model.HomeForSaleStatus;
import com.simco.watcher.model.HomeLightsStatus;
import com.simco.watcher.model.Observation;
import com.simco.watcher.model.Vehicle;

@Controller
@SessionAttributes({"homes", "vehicles", "observations"})
public class ObservationsController {

    private static final Logger logger = LoggerFactory.getLogger(ObservationsController.class);

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

    @GetMapping("/recordObservation")
    public String showNewObservation(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @ModelAttribute("observations") List<Observation> observations,
            Model model) {

        logger.info("showNewObservation invoked");

        // create empty Observation object for data-entry, but let's setup
        // default values for the form
        Observation observation = Observation.builder()
                .garageStatus(GarageStatus.CLOSED)
                .extLightsStatus(HomeLightsStatus.OFF)
                .intLightsStatus(HomeLightsStatus.OFF)
                .forSaleStatus(HomeForSaleStatus.NO_SIGN)
                .contractorStatus(ContractorStatus.NO_SIGN)
                .build();

        // add session variables
        model.addAttribute("homes", homes);
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("observations", observations);
        // add data necessary to render view
        model.addAttribute("newObservation", observation);
        return "record";
    }

    @PostMapping("/recordObservation")
    public ModelAndView recordObservation(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("vehicles") List<Vehicle> vehicles,
            @ModelAttribute("observations") List<Observation> observations,
            @ModelAttribute Observation newObservation,
            BindingResult errors,
            ModelMap model) {

        // set observation timestamp
        newObservation.setTimestamp(LocalDateTime.now());

        logger.info("recordObservation invoked - selectedHomeId=[{}], garageStatus=[{}], extLightsStatus=[{}], intLightsStatus=[{}], forSaleStatus=[{}], contractorStatus=[{}]",
                newObservation.getSelectedHomeId(),
                newObservation.getGarageStatus().getDisplayName(),
                newObservation.getExtLightsStatus().getDisplayName(),
                newObservation.getIntLightsStatus().getDisplayName(),
                newObservation.getForSaleStatus().getDisplayName(),
                newObservation.getContractorStatus().getDisplayName()
                );

        // TODO: take selectedId, lookup, set the Home property

        // assign ID to the new observation and add it to our collection
        newObservation.setId(UUID.randomUUID());
        observations.add(newObservation);

        // add session variables
        model.addAttribute("homes", homes);
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("observations", observations);
        return new ModelAndView("redirect:/", model);
    }

}
