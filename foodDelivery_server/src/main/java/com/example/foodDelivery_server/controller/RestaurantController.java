package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.entity.RestaurantEntity;
import com.example.foodDelivery_server.service.CardService;
import com.example.foodDelivery_server.service.RestaurantService;
import com.example.foodDelivery_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class RestaurantController {
    @Autowired
    CardService cardService;
    @Autowired
    RestaurantService restaurantService;


    @PostMapping("/restaurants")
    public ResponseEntity getAllRestaurants(@RequestBody Integer... id){
        System.out.println(id);
        List<RestaurantEntity> ls = cardService.getAllResrtaurants(id);
        return ResponseEntity.ok().body(ls);
    }

    @PostMapping("/restaurants/info")
    public ResponseEntity getRestaurantInfo(@RequestBody Map<String,Integer> map){
        System.out.println(map);
        if(map.get("id") == null) return ResponseEntity.badRequest().body("Id is required");
        return ResponseEntity.ok().body(restaurantService.getRestaurantInfo(map.get("id")));
    }

    @PostMapping("/addViewToRestaurant")
    public ResponseEntity addViewToRestaurant(@RequestBody Map<String,Integer> map){
       restaurantService.addViewToRestaurant(map.get("id"));
       return ResponseEntity.ok("all OK");
    }
}
