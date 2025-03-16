package com.simple.crud.thikanaApp.controller;


import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.service.ThikanaEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Thikana")
public class ThikanaEntryController {

    @Autowired
    private ThikanaEntryService thikanaEntryService;

    @PostMapping
    public boolean createEntry(@RequestBody ThikanaEntry myEntry){
        thikanaEntryService.saveEntry(myEntry);
        return true;
    }

}
