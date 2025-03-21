package com.simple.crud.thikanaApp.controller;


import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.entity.User;
import com.simple.crud.thikanaApp.service.ThikanaEntryService;
import com.simple.crud.thikanaApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }
    @PostMapping
    public boolean createUser(@RequestBody User user){
        userService.saveEntry(user);
        return true;
    }
    @PutMapping("/{PhoneNumber}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String PhoneNumber){
        User userInDb = userService.findByPhoneNumber(PhoneNumber);
        if(userInDb!=null){
            userInDb.setPhoneNumber(user.getPhoneNumber());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
