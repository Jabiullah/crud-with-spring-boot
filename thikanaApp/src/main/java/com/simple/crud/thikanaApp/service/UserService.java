package com.simple.crud.thikanaApp.service;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.entity.User;
import com.simple.crud.thikanaApp.repository.ThikanaEntryRepository;
import com.simple.crud.thikanaApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {
    // Here will be only business logics
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(User user){
        userRepository.save(user);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByPhoneNumber(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber);
    }

}
