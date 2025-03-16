package com.simple.crud.thikanaApp.repository;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThikanaEntryRepository extends MongoRepository<ThikanaEntry, ObjectId> {

}
// Controller ---> Service ---> Repository