package com.simple.crud.thikanaApp.repository;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThikanaEntryRepository extends MongoRepository<ThikanaEntry,String> {

}
// Controller ---> Service ---> Repository