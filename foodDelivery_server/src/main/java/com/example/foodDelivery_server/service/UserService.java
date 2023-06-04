package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.Exeptions.isUserExistExeption;
import com.example.foodDelivery_server.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public boolean isUserExist(String login){
        String sql = "SELECT COUNT (*) FROM users WHERE login = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,login) != 0;
    }

    public UserEntity getUser(String login, String password){
        return jdbcTemplate.query(
                "SELECT * FROM users where login = ? and password = ?",
                (rs,rowNum) -> new UserEntity(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("adress"),
                        rs.getString("date_of_registration"),
                        rs.getString("email"),
                        rs.getBoolean("isAdmin")
                ),login,password
        ).get(0);
    }
    public void addUser(UserEntity user) throws isUserExistExeption {
        if(isUserExist(user.login)){
           throw new isUserExistExeption("пользователь уже существует");
        }
        else{
            String sql = "INSERT INTO users (first_name, last_name, login, password, phone, adress ,email) VALUES(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,user.first_name, user.last_name,user.login,user.password,user.password,user.adress,user.email);
        }
    }
    public UserEntity auth(String login, String password){
        System.out.println( login + " service user " + password);

        String sql = "SELECT COUNT (*) FROM users WHERE login = ? and password = ?";
        if(jdbcTemplate.queryForObject(sql,Integer.class,login,password) == 1){
            return getUser(login,password);
        }
        else {
            throw new RuntimeException("Неправильный логин или пароль");
        }
    }
    public List<UserEntity> getUsers() {
        return jdbcTemplate.query(
                "SELECT * FROM users",
                (rs, rowNum) -> new UserEntity(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("adress"),
                        rs.getString("date_of_registration"),
                        rs.getString("email")
                )
        );
    }


}
