package com.dao;

import com.model.Contact;
import com.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactDAOImpl implements ContactDAO {

    private SessionFactory sessionFactory;


    @Override
    public Contact addContact(Contact contact) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(contact);
        session.getTransaction().commit();
        session.close();
        return contact;
    }

    @Override
    public Contact editContact(Contact contact) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(contact);
        session.getTransaction().commit();
        session.close();
        return contact;
    }

    @Override
    public Contact getId(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Contact contact = session.get(Contact.class, id);
        session.close();
        return contact;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> listContacts() {
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Contact> contactList = session.createQuery("from Contact ").list();
        session.close();
        return contactList;
    }

    @Override
    public void removeContact(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Contact contact = session.get(Contact.class, id);
        session.delete(contact);
        session.getTransaction().commit();
        session.close();
    }
}
