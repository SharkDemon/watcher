package com.simco.watcher.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

    // follow the image-naming convention!
    private static final String CARD_HOME_IMAGE_PATH = "/images/cards/home-%s.png";

    private Random rand = new Random();

    public String getRandomHomeCardImage() {
        return String.format(CARD_HOME_IMAGE_PATH, rand.nextInt(7) + 1);
    }

}
