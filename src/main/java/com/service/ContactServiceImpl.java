package com.service;

import com.dao.ContactDAO;
import com.model.Contact;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactDAO contactDAO;


    @Override
    public Contact addContact(Contact contact) {
        contactDAO.addContact(contact);
        return contact;
    }

    @Override
    public Contact editContact(Contact contact) {
        contactDAO.editContact(contact);
        return contact;
    }

    @Override
    public List<Contact> listContacts() {
        return contactDAO.listContacts();
    }

    @Override
    public Contact getId(int id) {
        return contactDAO.getId(id);
    }

    @Override
    public void removeContact(int id) {
        contactDAO.removeContact(id);
    }
}
