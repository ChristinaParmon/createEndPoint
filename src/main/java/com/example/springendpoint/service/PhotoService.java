package com.example.springendpoint.service;

import com.example.springendpoint.models.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(String title, MultipartFile file) throws IOException;

    Photo getPhoto(String id);
}
