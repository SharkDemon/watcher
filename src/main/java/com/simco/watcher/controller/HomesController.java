package com.simco.watcher.controller;

import java.time.LocalDateTime;
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

import com.simco.watcher.model.ContractorStatus;
import com.simco.watcher.model.Doorbell;
import com.simco.watcher.model.Home;
import com.simco.watcher.model.HomeForSaleStatus;
import com.simco.watcher.model.Observation;
import com.simco.watcher.model.SecurityCamera;

@Controller
public class HomesController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(HomesController.class);

    @GetMapping("/homes")
    public String showHomes(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute("observations") List<Observation> observations,
            Model model) {

        logger.info("showHomes invoked - returning homes=[{}]", homes.size());

        // set the signage property and mostRecentObservationTimestamp property
        // on each Home
        // remember that newly-created Homes will not yet have observations
        // ...YES, i know it's convoluted
        homes.stream().forEach(h -> {
            String signage = "";
            LocalDateTime latestObservationTimestamp = LocalDateTime.now();
            // get observations for this home, in desc order
            List<Observation> latestObservationList = observations.stream()
                    .filter(o -> o.getSelectedHomeId().equals(h.getId()))
                    .sorted(Comparator.comparing(Observation::getTimestamp).reversed())
                    .collect(Collectors.toList());
            if (0 < latestObservationList.size()) {
                Observation latestObservation = latestObservationList.get(0);
                if (latestObservation.getForSaleStatus().equals(HomeForSaleStatus.FOR_SALE_SIGN))
                    signage = HomeForSaleStatus.FOR_SALE_SIGN.getDisplayName();
                if (latestObservation.getContractorStatus().equals(ContractorStatus.CONTRACTOR_SIGN))
                    signage += ((0 == signage.length()) ? "" : ", ") + ContractorStatus.CONTRACTOR_SIGN.getDisplayName();
                latestObservationTimestamp = latestObservation.getTimestamp();
            }
            if (0 == signage.length())
                signage = "None";
            h.setSignage(signage);
            h.setMostRecentObservationTimestamp(latestObservationTimestamp);
        });

        // sort Homes by asc number and then by asc street
        homes = homes.stream()
                .sorted(Comparator.comparing(Home::getNumber).thenComparing(Home::getStreet))
                .collect(Collectors.toList());

        // add session variables
        model.addAttribute("homes", homes);
        model.addAttribute("observations", observations);
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

    @GetMapping("/homes/add")
    public String showAddHome(
            @ModelAttribute("homes") List<Home> homes,
            Model model) {

        logger.info("showAddVehicle invoked");

        Home newHome = Home.builder()
                .doorbell(Doorbell.NORMAL)
                .securityCamera(SecurityCamera.ABSENT)
                .build();

        // add session variables
        model.addAttribute("homes", homes);
        // add data necessary to render view
        model.addAttribute("newHome", newHome);
        return "addHome";
    }

    @PostMapping("/homes/add")
    public ModelAndView addHome(
            @ModelAttribute("homes") List<Home> homes,
            @ModelAttribute Home newHome,
            BindingResult errors,
            ModelMap model) {

        newHome.setNumber(newHome.getNumber().trim());
        newHome.setStreet(newHome.getStreet().trim());
        newHome.setCity(newHome.getCity().trim());
        newHome.setZip(newHome.getZip().trim());

        logger.info("addHome invoked - number=[{}], street=[{}], city=[{}], state=[{}], zip=[{}]",
                newHome.getNumber(),
                newHome.getStreet(),
                newHome.getCity(),
                newHome.getState().getAbbreviation(),
                newHome.getZip());

        // assign ID to the new Vehicle and add it to our collection
        newHome.setId(UUID.randomUUID());
        homes.add(newHome);

        // add session variables
        model.addAttribute("homes", homes);
        return new ModelAndView("redirect:/homes", model);
    }

}
