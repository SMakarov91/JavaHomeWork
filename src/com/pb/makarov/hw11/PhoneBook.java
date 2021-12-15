package com.pb.makarov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PhoneBook {

    private String fio;
    private LocalDate dateOfBirth;
    private String phone;
    private String address;
    private LocalDateTime mod;

    public PhoneBook(){
    }

    public PhoneBook(String fio, LocalDate dateOfBirth, String phone, String address) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.mod = LocalDateTime.now();
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
        this.mod = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.mod = LocalDateTime.now();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.mod = LocalDateTime.now();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.mod = LocalDateTime.now();
    }

    public LocalDateTime getMod() {
        return mod;
    }

    public void setMod(LocalDateTime mod) {
        this.mod = mod;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", mod=" + mod +
                '}';
    }
}
