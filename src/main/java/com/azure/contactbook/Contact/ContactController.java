package com.azure.contactbook.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }

    @GetMapping("/all")
    public String viewAllContacts(Model model) {
        model.addAttribute("allContacts", contactService.getContacts());
        return "all";
    }

    @GetMapping("/new")
    public String showNewContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "new";
    }

    @PostMapping("/new")
    public String createNewContact(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateContact(@ModelAttribute("contact") Contact contact, @PathVariable("id") int id) {
        contactService.updateContact(contact);
        return "redirect:/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id) {
        contactService.deleteContact(id);
        return "redirect:/all";
    }
}
