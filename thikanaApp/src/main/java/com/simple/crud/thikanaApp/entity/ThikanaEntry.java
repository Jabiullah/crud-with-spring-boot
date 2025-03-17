package com.simple.crud.thikanaApp.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "thikana_entries")
@Data
//We need to map this with our db which will be as 'collection'. That's why we have added this document annotation.
public class ThikanaEntry {
    @Id
    //This will be mapped as primary Key.
    private ObjectId id;
    private String address;
    private String code;
    private LocalDateTime date;

}
