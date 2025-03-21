package com.simple.crud.thikanaApp.repository;

import com.simple.crud.thikanaApp.entity.ThikanaEntry;
import com.simple.crud.thikanaApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByPhoneNumber(String phoneNumber);
}
// Controller ---> Service ---> Repository