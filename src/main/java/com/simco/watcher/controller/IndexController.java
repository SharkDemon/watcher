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
        // with some dummy data
        if (null == homes)
            homes = dataService.getAllHomes();
        if (null == vehicles)
            vehicles = dataService.getAllVehicles();

        String homesCardImagePath = imageService.getRandomHomeCardImage();

        logger.info("showIndex invoked - returning homes=[{}], vehicles=[{}], homesImage=[{}]",
                homes.size(),
                vehicles.size(),
                homesCardImagePath
                );

        // add session variables
        model.addAttribute("homes", homes);
        model.addAttribute("vehicles", vehicles);
        // add data necessary to render view
        model.addAttribute("homesCardImagePath", homesCardImagePath);
        //model.addAttribute("newContact", new Contact());
        return "index";
    }

    /*    @PostMapping("/addContact")
    public ModelAndView addContact(
            @ModelAttribute("contacts") List<Contact> currentContacts,
            @ModelAttribute Contact newContact,
            BindingResult errors,
            ModelMap model) {

        logger.info("addContact invoked - firstName=[{}], lastName=[{}], email=[{}]",
                newContact.getFirstName(),
                newContact.getLastName(),
                newContact.getEmail());

        // assign ID to the new contact and add it to our collection
        newContact.setId(UUID.randomUUID());
        currentContacts.add(newContact);

        model.addAttribute("contacts", currentContacts);
        return new ModelAndView("redirect:/", model);
    }
     */
    /*    @GetMapping("/editContact/{contactId}")
    public String showEditContact(
            @ModelAttribute("contacts") List<Contact> currentContacts,
            @PathVariable UUID contactId,
            ModelMap model) {

        logger.info("showEditContact invoked - contactId=[{}]", contactId);

        // get the contact matching on UUID
        Contact contactToEdit = currentContacts.stream()
                .filter(cc -> cc.getId().equals(contactId))
                .collect(Collectors.toList())
                .get(0); // let's assume a find

        model.addAttribute("contacts", currentContacts);
        model.addAttribute("contactToEdit", contactToEdit);
        return "editContact";
    }
     */
    /*    @PostMapping("/editContact/{contactId}")
    public ModelAndView editContact(
            @ModelAttribute("contacts") List<Contact> currentContacts,
            @ModelAttribute Contact editedContact,
            @PathVariable UUID contactId,
            ModelMap model) {

        logger.info("editContact invoked - id=[{}], firstName=[{}], lastName=[{}], email=[{}]",
                contactId,
                editedContact.getFirstName(),
                editedContact.getLastName(),
                editedContact.getEmail());

        // apply id to the submitted object, since the id was not passed via
        // the HTML fields
        editedContact.setId(contactId);

        // insert the submitted contact into our contacts list from session
        int indexOfInterest = 0;
        for (Contact c : currentContacts) {
            if (c.getId().equals(contactId))
                break;
            indexOfInterest++;
        }
        currentContacts.set(indexOfInterest, editedContact);

        model.addAttribute("contacts", currentContacts);
        return new ModelAndView("redirect:/", model);
    }
     */
    /*    @GetMapping("/removeContact/{contactId}")
    public ModelAndView removeContact(
            @ModelAttribute("contacts") List<Contact> currentContacts,
            @PathVariable UUID contactId,
            ModelMap model) {

        logger.info("removeContact invoked - contactId=[{}]", contactId);

        // remove contacts matching on UUID
        currentContacts = currentContacts.stream()
                .filter(cc -> !cc.getId().equals(contactId))
                .collect(Collectors.toList());

        model.addAttribute("contacts", currentContacts);
        return new ModelAndView("redirect:/", model);
    }
     */
}
