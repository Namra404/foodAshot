package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.entity.RestaurantCategoryEntity;
import com.example.foodDelivery_server.entity.RestaurantEntity;
import com.example.foodDelivery_server.service.RestaurantCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestaurantCategoryController {

    @Autowired
    RestaurantCategoryService restaurantCategoryService;

    @PostMapping("/sortedRestaurants")
    public ResponseEntity getAllRestaurants(@RequestBody Integer... ids){
        System.out.println(ids);
        List<Long> ls = restaurantCategoryService.restaurantIncludeCategory(ids);
        return ResponseEntity.ok().body(ls);
    }
}
