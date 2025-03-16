package com.simple.crud.thikanaApp.controller;


import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.service.ThikanaEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Thikana")
public class ThikanaEntryController {

    @Autowired
    private ThikanaEntryService thikanaEntryService;

    @PostMapping
    public boolean createEntry(@RequestBody ThikanaEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        thikanaEntryService.saveEntry(myEntry);
        return true;
    }
    @GetMapping
    public List<ThikanaEntry> getAll(){
        return thikanaEntryService.getAll();
    }


    @GetMapping("id/{myId}")
    public ThikanaEntry getThikanaEntryById(@PathVariable ObjectId myId){
       return thikanaEntryService.findById(myId).orElse(null);
    }
}
