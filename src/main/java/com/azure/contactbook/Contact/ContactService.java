package com.azure.contactbook.Contact;

import java.io.FileWriter;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jakarta.annotation.PreDestroy;

@Service
public class ContactService {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private int nextID = 1;

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        contact.setId(nextID++);
        contacts.add(contact);
    }

    public Contact getContactById(int id) {
        for (Contact c : contacts) {
            if (c.getId() == id) {
                return c;
            }
        }
        
        return null;
    }

    public void updateContact(Contact newContact) {
        for (Contact c : contacts) {
            if (c.getId() == newContact.getId()) {
                int i = contacts.indexOf(c);
                contacts.set(i, newContact);
                return;
            }
        }
    }

    public void deleteContact(int id) {
        Contact toDelete = null;
        
        for (Contact c : contacts) {
            if (c.getId() == id) {
                toDelete = c;
                break;
            }
        }

        contacts.remove(toDelete);
    }

    @PreDestroy
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("contacts.txt");
            writer.append("All Contacts Currently in List:\n");

            for (int i = 0; i < getContacts().size(); i++) {
                writer.append("----------\n");
                writer.append("First name: " + getContacts().get(i).getFirstName() + "\n");
                writer.append("Last name: " + getContacts().get(i).getLastName() + "\n");
                writer.append("Phone: " + getContacts().get(i).getPhoneNum() + "\n");
                writer.append("Email: " + getContacts().get(i).getEmail() + "\n");
                writer.append("Address: " + getContacts().get(i).getAddress() + "\n");
            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
