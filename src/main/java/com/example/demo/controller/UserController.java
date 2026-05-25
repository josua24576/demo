package com.example.demo.controller;

import com.example.demo.model.UserData;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public UserData addUser(@RequestBody UserData user) {
        return userRepository.save(user);
    }

//    @PostMapping("/add")
//    public String addUserWithProcedure(@RequestBody Map<String, Object> nama) {
//        userRepository.addUser(nama);
//        return "User berhasil ditambahkan";
//    }

    @PostMapping("/add")
    public String addUserWithProcedure(@RequestBody UserData request) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(request);
        userRepository.insertUser(json);

        return "User berhasil ditambahkan";
    }
}