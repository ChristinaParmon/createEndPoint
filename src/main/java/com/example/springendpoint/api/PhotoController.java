package com.example.springendpoint.api;


import com.example.springendpoint.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping(value = "/users/photos")
    public String addPhoto(
            @RequestParam("image") MultipartFile image)
            throws IOException {
        return photoService.addPhoto(image);
    }
}
