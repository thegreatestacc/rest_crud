package com.sovliv.rest_crud.controllers;

import com.sovliv.rest_crud.model.User;
import com.sovliv.rest_crud.service.UserService;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> allUsers() {
        return userService.getAllUsers();
    }

    @SneakyThrows
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        return userService.delete(id);
    }
}
