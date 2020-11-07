package com.simco.watcher.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

    // follow the image-naming conventions!
    private static final String CARD_HOME_IMAGE_PATH = "/images/cards/home-%s.png";
    private static final String CARD_VEHICLE_IMAGE_PATH = "/images/cards/vehicle-%s.png";

    private Random rand = new Random();

    public String getRandomHomeCardImage() {
        return String.format(CARD_HOME_IMAGE_PATH, rand.nextInt(7) + 1);
    }

    public String getRandomVehicleCardImage() {
        return String.format(CARD_VEHICLE_IMAGE_PATH, rand.nextInt(6) + 1);
    }

}
