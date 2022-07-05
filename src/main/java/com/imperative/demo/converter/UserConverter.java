package com.imperative.demo.converter;

import com.imperative.demo.dto.UserDTO;
import com.imperative.demo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public static List<UserDTO> toDTO(List<User> entityList){
        if(entityList == null || entityList.isEmpty()) return new ArrayList<>();

        return entityList.stream().map(UserConverter::toDTO).collect(Collectors.toList());
    }

    public static UserDTO toDTO(User entity){
        return new UserDTO(entity.getId(), entity.getName());
    }

    public static User toEntity(UserDTO dto){
        return new User(dto.getId(), dto.getName());
    }
}
