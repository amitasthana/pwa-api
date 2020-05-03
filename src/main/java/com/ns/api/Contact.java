package com.ns.api;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contacts")
@Data
public class Contact {

    @Id
    String id;
    String name;
    String address;
    String city;
    String phone;
    String email;

    public Contact() {
    }

    public Contact(String name, String address, String city, String phone, String email) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }
}
