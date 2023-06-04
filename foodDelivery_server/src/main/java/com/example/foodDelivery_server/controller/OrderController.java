package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.entity.OrderEntity;
import com.example.foodDelivery_server.entity.OrderItemEntity;
import com.example.foodDelivery_server.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;





}
