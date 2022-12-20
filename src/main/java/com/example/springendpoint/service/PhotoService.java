package com.example.springendpoint.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    String addPhoto(MultipartFile file) throws IOException;
}
