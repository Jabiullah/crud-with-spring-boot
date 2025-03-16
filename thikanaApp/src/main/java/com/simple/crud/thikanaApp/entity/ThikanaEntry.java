package com.simple.crud.thikanaApp.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "thikana_entries")
//We need to map this with our db which will be as 'collection'. That's why we have added this document annotation.
public class ThikanaEntry {
    @Id
    //This will be mapped as primary Key.
    private String id;
    private String address;
    private String code;



    private Date date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
