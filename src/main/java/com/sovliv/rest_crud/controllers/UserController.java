package com.sovliv.rest_crud.controllers;

import com.sovliv.rest_crud.model.User;
import com.sovliv.rest_crud.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Iterable<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/edit/{id}")
    public User editUser(@RequestBody User user, @PathVariable Long id) {
        return userService.update(user, id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
