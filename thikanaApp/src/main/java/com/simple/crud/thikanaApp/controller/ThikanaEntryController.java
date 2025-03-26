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
@RequestMapping("Thikana")
public class ThikanaEntryController {

    @Autowired
    private ThikanaEntryService thikanaEntryService;
    @Autowired
    private UserService userService;

    @PostMapping("{phoneNumber}")
    public boolean createEntry(@RequestBody ThikanaEntry myEntry, @PathVariable String phoneNumber){
        try {
            myEntry.setDate(LocalDateTime.now());
            thikanaEntryService.saveEntry(myEntry,phoneNumber);
            return true;
        }catch (Exception e){
            System.out.println("Create Entry Exception: "+e);
            return false;
        }
    }

    @GetMapping
    public List<ThikanaEntry> getAll(){
        return thikanaEntryService.getAll();
    }


    @GetMapping("{phoneNumber}")
    public ResponseEntity<?> getAllThikanaEntriesOfUser(@PathVariable String phoneNumber){
        User byPhoneNumber = userService.findByPhoneNumber(phoneNumber);

        List<ThikanaEntry> all = byPhoneNumber.getThikanaEntries();
        if(all != null && !all.isEmpty()){
           return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{phoneNumber}/{myId}")
    public boolean deleteThikanaEntryById(@PathVariable ObjectId myId, @PathVariable String phoneNumber){
        thikanaEntryService.deleteById(myId, phoneNumber);
        return true;
    }
    @PutMapping("/id/{phoneNumber}/{id}")
    public ThikanaEntry updateThikanaById(
            @PathVariable ObjectId id,
            @RequestBody ThikanaEntry newEntry,
            @PathVariable String phoneNumber){
        ThikanaEntry old = thikanaEntryService.findById(id).orElse(null);

        if(old!=null){
            old.setAddress(newEntry.getAddress() !=null && !newEntry.getAddress().equals("") ? newEntry.getAddress() : old.getAddress());
            old.setCode(newEntry.getCode() !=null && !newEntry.getCode().equals("") ? newEntry.getCode() : old.getCode());
        }
        thikanaEntryService.saveEntry(old);
        return old;
    }


}
