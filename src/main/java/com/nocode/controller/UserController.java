package com.nocode.controller;

import com.nocode.pojo.User;
import com.nocode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.jcabi.aspects.Loggable;

@RestController
@Loggable(prepend = true, logThis = true)
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Inserts a student into the database
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    //Retrives all students from the database
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = userService.getUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //Retrives a single student with the specified email from the database
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    //Updates the student with the email passed as path variable
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.OK);
    }

    //Deletes a student with the email passed as the path variable
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }
}