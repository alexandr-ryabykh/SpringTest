package com.dao;

import com.model.Contact;

import java.util.List;

public interface ContactDAO {
    public Contact addContact(Contact contact);

    public Contact editContact(Contact contact);

    public Contact getId(int id);

    public List<Contact> listContacts();

    public void removeContact(int id);


}
