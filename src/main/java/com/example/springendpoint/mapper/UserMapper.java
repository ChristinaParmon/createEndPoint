package com.example.springendpoint.mapper;

import com.example.springendpoint.dto.UserDto;
import com.example.springendpoint.models.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Named("toEntity")
    User toEntity(UserDto dto);

    @Named("toDto")
    UserDto toDto(User user);

    @IterableMapping(qualifiedByName = "toEntity")
    List<User> toEntities(List<UserDto> userDtos);

    @IterableMapping(qualifiedByName = "toDto")
    List<UserDto> toDtos(List<User> users);


}
