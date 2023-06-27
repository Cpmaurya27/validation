package com.example.validation.service;

import com.example.validation.model.User;
import com.example.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> getAllUserFromService() {
        return userRepository.getAllUserFromRepository();
    }

    public String addUserToService(User user) {
        boolean insertion = userRepository.save(user);
        if(insertion){
            return "User added Successfully!!!!!";
        }
        else{
            return "Adding new user failed!!!!!.....";
        }
    }

    public User getUserByUserId(String userId) {
        List<User> availableUser = userRepository.getAllUserFromRepository();
        for(User user: availableUser){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }

    public String deleteUserFromList(String userId) {
        boolean deleteResponse = false;
        String status;
        if(userId != null){
            List<User> availableUser = userRepository.getAllUserFromRepository();
            for(User user : availableUser){
                if(user.getUserId().equals(userId)){
                    deleteResponse = userRepository.remove(user);
                    if(deleteResponse){
                        status =  "User with " + userId + " deleted successfully!!!....";
                    }
                    else {
                        status = "User with " + userId + " deletion is not possible!";
                    }
                    return status;
                }
            }
            return "user with " + userId + " does not exist!..";
        }
        else{
            return "Invalid userId.... cannot be null userId";
        }
    }

    public String updateUser(String userId, String status) {
        boolean updateStatus = userRepository.update(userId, status);
        if(updateStatus){
            return "user with " + userId+ " updated successfully!!!!!....";
        }
        else{
            return "user with " + userId + " update failed!";
        }
    }
}
