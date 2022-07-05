package com.imperative.demo.service;

import com.imperative.demo.converter.UserConverter;
import com.imperative.demo.dto.UserDTO;
import com.imperative.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserDTO> findAll() {
        var entityList = repo.findAll();
        return UserConverter.toDTO(entityList);
    }

    public UserDTO findById(String id) {
        var entity = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return UserConverter.toDTO(entity);
    }

    public UserDTO save(UserDTO dto) {
        var entity = repo.save(UserConverter.toEntity(dto));
        return UserConverter.toDTO(entity);
    }
}
