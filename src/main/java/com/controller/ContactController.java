package com.controller;

import com.dao.ContactDAO;
import com.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller()
public class ContactController {

    private ContactDAO contactDAO;

    public void setContactDAO(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @RequestMapping(value = "/ls", method = RequestMethod.GET)
    public String listContacts(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("listContacts", this.contactDAO.listContacts());
        return "welcome";
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.GET)
    public String addContact(@ModelAttribute("contact") Contact contact) {

        if (contact.getId() == 0) {
            this.contactDAO.addContact(contact);
        }
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public String editContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.getId(contactId);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String removeContact(HttpServletRequest request) {
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.removeContact(contactId);
        return ("redirect:/welcome");
    }
}

