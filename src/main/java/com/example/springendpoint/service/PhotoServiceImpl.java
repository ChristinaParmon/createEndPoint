package com.example.springendpoint.service;

import com.example.springendpoint.models.Photo;
import com.example.springendpoint.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    @Override
    public String addPhoto(MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepository.insert(photo);
        return photo.getId();
    }

}
