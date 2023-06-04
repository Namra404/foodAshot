package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    JdbcTemplate jdbcTemplate;


}
