package com.dao;

import com.model.Contact;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

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
        List<Contact> personsList = sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
        return personsList;
    }

    @Override
    public void removeContact(int id) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Contact WHERE id = " + id).executeUpdate();

    }
}
