package com.service;

import com.model.Contact;

import java.util.List;

public interface ContactService {
    public Contact addContact(Contact contact);

    public Contact editContact(Contact contact);

    public List<Contact> listContacts();

    public  Contact getId(int id);

    public void removeContact(int id);
}
