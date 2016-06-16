package com.controller;

import com.dao.ContactDAOImpl;
import com.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller()
public class ContactController {

    private ContactDAOImpl contactDAOimpl;

    @Autowired
    public ContactController(ContactDAOImpl contactDAOimpl) {
        this.contactDAOimpl = contactDAOimpl;
    }

    public ContactController() {
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/currentDate", method = RequestMethod.GET)
    public String all(Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("currentTime", formattedDate);
        return "currentDate";
    }

    @RequestMapping(value = "/contact/all", method = RequestMethod.GET)
    public String listContacts(Model model) {
        List<Contact> contactList = this.contactDAOimpl.listContacts();
        model.addAttribute("contactList", contactList);
        return "contactList";
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.GET)
    public String getContact(Model model) {
        model.addAttribute("personAttribute", new Contact());
        return "addContact";
    }

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("personAttribute") Contact contact) {
        this.contactDAOimpl.addContact(contact);
        return "redirect:/contact/all";
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ModelAndView getEditContact(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("editContact");
        Contact contact = this.contactDAOimpl.getId(id);
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.POST)
    public String saveEditContact(Contact contact) {
        this.contactDAOimpl.editContact(contact);
        return "redirect:/contact/all";
    }

    @RequestMapping(value = "/contact/{id}/remove", method = RequestMethod.GET)
    public String removeContact(@PathVariable int id) {
        this.contactDAOimpl.removeContact(id);
        return "redirect:/contact/all";
    }
}

