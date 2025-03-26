package com.simple.crud.thikanaApp.service;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.entity.User;
import com.simple.crud.thikanaApp.repository.ThikanaEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ThikanaEntryService {
    // Here will be only business logics
    @Autowired
    private ThikanaEntryRepository thikanaEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(ThikanaEntry thikanaEntry, String phoneNumber){
        User byPhoneNumber = userService.findByPhoneNumber(phoneNumber);
        ThikanaEntry saved = thikanaEntryRepository.save(thikanaEntry);

        byPhoneNumber.getThikanaEntries().add(saved);
        userService.saveEntry(byPhoneNumber);
    }

    public void saveEntry(ThikanaEntry thikanaEntry){
        ThikanaEntry saved = thikanaEntryRepository.save(thikanaEntry);
    }

    public List<ThikanaEntry> getAll(){
        return thikanaEntryRepository.findAll();
    }
    public Optional<ThikanaEntry> findById(ObjectId id){
        return thikanaEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String phoneNumber){
        User byPhoneNumber = userService.findByPhoneNumber(phoneNumber);
        byPhoneNumber.getThikanaEntries().removeIf(x-> x.getId().equals(id));
        userService.saveEntry(byPhoneNumber);

        thikanaEntryRepository.deleteById(id);
    }

}
