package com.utils;

import com.model.Contact;
import org.hibernate.Session;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Contact contact = new Contact();

        contact.setFirstName("Alex");
        contact.setLastName("R");
        contact.setId(1);
        contact.setAddress("odessa");
        contact.setEmail("gg@gmail.com");
        contact.setTelephone(223332);

        session.save(contact);
        session.getTransaction().commit();

        session.close();


    }
}
