package com.simple.crud.thikanaApp.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document
//We need to map this with our db which will be as 'collection'. That's why we have added this document annotation.
public class ThikanaEntry {
    private String id;
    private String address;
    private String code;
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getCode() {
        return code;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
