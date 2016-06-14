package com.utils;

import com.model.Contact;
import org.hibernate.Session;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        Contact contact = new Contact();
        Contact contact1 = new Contact();

        contact.setFirstName("Alex");
        contact.setLastName("R");
        contact.setId(1);
        contact.setAddress("odessa");
        contact.setEmail("gg@gmail.com");
        contact.setTelephone(223332);

        contact1.setFirstName("Vasya");
        contact1.setLastName("M");
        contact1.setId(2);
        contact1.setAddress("kyiv");
        contact1.setEmail("aa@mail.ru");
        contact1.setTelephone(556655);

        session.delete(contact);
        session.save(contact1);
        session.getTransaction().commit();

        session.close();


    }
}
