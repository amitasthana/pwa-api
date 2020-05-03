package com.ns.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class ContactController {

    @Autowired
    ContactService contactService;

    @CrossOrigin
    @GetMapping("/contacts")
    public Iterable<Contact> contact() {
        return contactService.findAll();
    }

    @CrossOrigin
    @PostMapping("/contacts")
    public ResponseEntity<Object> save(@RequestBody Contact contact) {
        log.info("Request : {}", contact);
        contactService.saveContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin
    @GetMapping("/contacts/{id}")
    public Optional<Contact> show(@PathVariable String id) {
        return contactService.findById(id);
    }

    @CrossOrigin
    @PutMapping("/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Optional<Contact> optcontact = contactService.findById(id);
        Contact c = optcontact.get();
        if(contact.getName() != null)
            c.setName(contact.getName());
        if(contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            c.setCity(contact.getCity());
        if(contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactService.saveContact(c);
        return c;
    }

    @CrossOrigin
    @DeleteMapping("/contacts/{id}")
    public String delete(@PathVariable String id) {
        Optional<Contact> optcontact = contactService.findById(id);
        Contact contact = optcontact.get();
        contactService.deleteContact(contact);

        return "";
    }

}
