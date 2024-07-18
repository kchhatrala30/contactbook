package com.azure.contactbook.Contact;

public class Contact extends Person {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String email;
    private String address;

    public Contact() {

    }

    public Contact(int id, String firstName, String lastName, String phoneNum, String email, String address) {
        super(firstName, lastName);
        this.id = id;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
