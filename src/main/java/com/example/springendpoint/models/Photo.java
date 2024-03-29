package com.example.springendpoint.models;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "photos")
public class Photo {
    @Id
    private String id;

    private Binary image;
}

