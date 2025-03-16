package com.simple.crud.thikanaApp.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "thikana_entries")
//We need to map this with our db which will be as 'collection'. That's why we have added this document annotation.
public class ThikanaEntry {
    @Id
    //This will be mapped as primary Key.
    private ObjectId id;
    private String address;
    private String code;
    private LocalDateTime date;

    public ObjectId getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getCode() {
        return code;
    }
    public LocalDateTime getDate() {
        return date;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
