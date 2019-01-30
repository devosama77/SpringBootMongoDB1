package org.osama.hadara.student.model;

public class Contact {
    String city;
    String street;
    String phone1;
    String phone2;

    public Contact() {
    }

    public Contact(String city, String street, String phone1, String phone2) {
        this.city = city;
        this.street = street;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
