package com.example.springendpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(setterPrefix = "set")
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String photoId;
}
