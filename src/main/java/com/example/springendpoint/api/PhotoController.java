package com.example.springendpoint.api;

import com.example.springendpoint.models.Photo;
import com.example.springendpoint.service.PhotoService;
import com.example.springendpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class PhotoController {
    private final PhotoService photoService;
    private final UserService userService;
    @Autowired
    public PhotoController(PhotoService photoService, UserService userService) {
        this.photoService = photoService;
        this.userService = userService;
    }

    @PostMapping("/users/{id}/photos")
    public String addPhoto(
                           @RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image,
                           @PathVariable Long id)
            throws IOException {

        String photoId = photoService.addPhoto(title, image);
        userService.findById(id).setPhotoId(photoId);

        return "redirect:/photos/" + photoId;
    }

    @GetMapping("/photos/{id}")
    public Model getPhoto(@PathVariable String id, Model model) {
        Photo photo = photoService.getPhoto(id);
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return model;
    }
}
