package com.simple.crud.thikanaApp.service;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.repository.ThikanaEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ThikanaEntryService {
    // Here will be only business logics
    @Autowired
    private ThikanaEntryRepository thikanaEntryRepository;

    public void saveEntry(ThikanaEntry thikanaEntry){
        thikanaEntryRepository.save(thikanaEntry);
    }
    public List<ThikanaEntry> getAll(){
        return thikanaEntryRepository.findAll();
    }
}
