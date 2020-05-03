package com.ns.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {return contactRepository.save(contact);}

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findById(String id) {
        return contactRepository.findById(id);
    }

    public String deleteContact(Contact contact) { contactRepository.delete(contact); return ""; }
}
