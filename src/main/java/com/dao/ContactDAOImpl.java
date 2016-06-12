package com.dao;

import com.model.Contact;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDAOImpl implements ContactDAO {

    private SessionFactory sessionFactory;


    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().persist(contact);

    }

    @Override
    public void editContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);

    }

    @Override
    public Contact getId(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Contact WHERE id=" + id);
        return (Contact) query;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> listContacts() {
        List<Contact> contactList = sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
        return contactList;
    }

    @Override
    public void removeContact(int id) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Contact WHERE id = " + id).executeUpdate();

    }
}
