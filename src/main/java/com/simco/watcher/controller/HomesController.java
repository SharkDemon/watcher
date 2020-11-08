package com.simco.watcher.controller;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.simco.watcher.model.Home;
import com.simco.watcher.model.Observation;
import com.simco.watcher.service.DummyDataService;

@Controller
@SessionAttributes({"homes", "observations"})
public class HomesController {

    private static final Logger logger = LoggerFactory.getLogger(HomesController.class);

    @Autowired
    private DummyDataService dataService;

    // keep the list of Home objects in the session
    @ModelAttribute("homes")
    public List<Home> homesList() {
        return null;
    }

    // keep the list of Observation objects in the session
    @ModelAttribute("observations")
    public List<Observation> observationsList() {
        return null;
    }

    @GetMapping("/homes")
    public String showHomes(
            @ModelAttribute("homes") List<Home> homes,
            Model model) {

        // just in case we visit this page first, ensure homes list
        // has been initialized and populated with dummy data
        if (null == homes)
            homes = dataService.getAllHomes();

        logger.info("showHomes invoked - returning homes=[{}]",
                homes.size()
                );

        // add session variables
        model.addAttribute("homes", homes);
        return "homes";
    }

    @GetMapping("/homes/edit/{homeId}")
    public String showEditHome(
            @ModelAttribute("homes") List<Home> homes,
            @PathVariable UUID homeId,
            ModelMap model) {

        logger.info("showEditHome invoked - homeId=[{}]", homeId);

        // get the home matching on UUID
        Home homeToEdit = homes.stream()
                .filter(cc -> cc.getId().equals(homeId))
                .collect(Collectors.toList())
                .get(0); // let's assume a find

        model.addAttribute("homes", homes);
        model.addAttribute("homeToEdit", homeToEdit);
        return "editHome";
    }

    @PostMapping("/homes/edit/{homeId}")
    public ModelAndView editHome(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute Home editedHome,
            @PathVariable UUID homeId,
            ModelMap model) {

        logger.info("editHome invoked - id=[{}]",
                homeId);

        // find the existing Home so that we can update its properties
        int indexOfInterest = 0;
        for (Home h : homes) {
            if (h.getId().equals(homeId))
                break;
            indexOfInterest++;
        }
        homes.get(indexOfInterest).setDoorbell(editedHome.getDoorbell());
        homes.get(indexOfInterest).setSecurityCamera(editedHome.getSecurityCamera());

        model.addAttribute("homes", homes);
        return new ModelAndView("redirect:/homes", model);
    }

    @GetMapping("/homes/remove/{homeId}")
    public ModelAndView removeHome(
            @ModelAttribute("homes") List<Home> homes,
            @PathVariable UUID homeId,
            ModelMap model) {

        logger.info("removeHome invoked - homeId=[{}]", homeId);

        // remove homes (should be just one) matching on UUID
        homes = homes.stream()
                .filter(h -> !h.getId().equals(homeId))
                .collect(Collectors.toList());

        // add session variables
        model.addAttribute("homes", homes);
        return new ModelAndView("redirect:/homes", model);
    }


    @GetMapping("/homes/history/{homeId}")
    public String showHomeHistory(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("observations") List<Observation> observations,
            @PathVariable UUID homeId,
            Model model) {

        // get the home matching on UUID
        Home homeToShowHistory = homes.stream()
                .filter(h -> h.getId().equals(homeId))
                .collect(Collectors.toList())
                .get(0); // let's assume a find

        // find observations for the specified home (matching on UUID) and
        // sort in descending
        List<Observation> homeObservations = observations.stream()
                .filter(ho -> ho.getHome().getId().equals(homeId))
                .sorted(Comparator.comparing(Observation::getTimestamp).reversed())
                .collect(Collectors.toList());

        logger.info("showHomeHistory invoked - found [{}] observations for homeId=[{}]",
                homeObservations.size(),
                homeId
                );

        // add data necessary to render view
        model.addAttribute("homeToShowHistory", homeToShowHistory);
        model.addAttribute("homeObservations", homeObservations);
        return "homeHistory";
    }

}
