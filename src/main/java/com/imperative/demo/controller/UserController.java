package com.imperative.demo.controller;

import com.imperative.demo.dto.UserDTO;
import com.imperative.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }
}
