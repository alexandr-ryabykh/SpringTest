package com.service;

import com.dao.ContactDAO;
import com.model.Contact;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    private ContactDAO contactDAO;


    @Override
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    public void editContact(Contact contact) {
        contactDAO.editContact(contact);
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
