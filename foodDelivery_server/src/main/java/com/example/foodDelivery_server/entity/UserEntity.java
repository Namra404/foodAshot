package com.example.foodDelivery_server.entity;

import com.example.foodDelivery_server.service.UserService;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;
import java.util.Date;


public class UserEntity {

    public Long id;
    public String first_name;
    public String last_name;
    public String login;
    public String password;
    public String phone;
    public String adress;
    public String date_of_registration;
    public String email;
    public boolean isAdmin;

    public UserEntity(Long id, String first_name, String last_name, String login, String password, String phone, String adress, String date_of_registration, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.date_of_registration = date_of_registration;
        this.email = email;
    }

    public UserEntity(Long id, String first_name, String last_name, String login, String password, String phone, String address, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = address;
        this.email = email;
    }

    public UserEntity(String first_name, String last_name, String login, String password, String phone, String address, String date_of_registration, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = address;
        this.date_of_registration = date_of_registration;
        this.email = email;
    }

    public UserEntity(){}

    public UserEntity(String first_name, String last_name, String login, String password, String phone, String adress, String date_of_registration, String email, boolean isAdmin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.date_of_registration = date_of_registration;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public UserEntity(String first_name, String last_name, String login, String password, String phone, String adress, String email, boolean isAdmin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public UserEntity(Long id, String first_name, String last_name, String login, String password, String phone, String adress, String email, boolean isAdmin) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public UserEntity(Long id, String first_name, String last_name, String login, String password, String phone, String adress, String date_of_registration, String email, boolean isAdmin) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.adress = adress;
        this.date_of_registration = date_of_registration;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + adress + '\'' +
                ", date_of_registration='" + date_of_registration + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
