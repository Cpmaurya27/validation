package com.example.validation.controler;

import com.example.validation.model.User;
import com.example.validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get all value.......
    @GetMapping(value = "/getAllUser")

    public List<User> getAllUser(){
        return userService.getAllUserFromService();
    }

    // Add user.............
    @PostMapping(value = "/addUser")

    public String addUserToService(@Valid @RequestBody User user){
        return userService.addUserToService(user);
    }

    //getUserByUserId.............

    @RequestMapping(value = "/getUserByUserId/{userId}", method = RequestMethod.GET)

    public User getUserByUserId(@PathVariable String userId){
        return userService.getUserByUserId(userId);
    }

    // Delete user

    @DeleteMapping(value = "/deleteUserByUserId/{userId}")
    public String deleteUser(@PathVariable String userId){
        return userService.deleteUserFromList(userId);
    }

    //Update user............................................

    @PutMapping(value = "/updateUser/{userId}/{status}")
    public String updateUser(@PathVariable String userId, @PathVariable String status){
        return userService.updateUser(userId, status);
    }




}
