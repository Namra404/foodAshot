package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class MenuItemsController {
    @Autowired
    MenuItemsService menuItemsService;

    @PostMapping("/restaurantMenu")
    public ResponseEntity getAllMenuItemsByRestaurantID(@RequestBody Integer id){
        return ResponseEntity.ok().body(menuItemsService.getAllMenuItemsByRestaurantID(id));
    }
    @PostMapping("/getMenuItem")
    public ResponseEntity getMenuItemByID(@RequestBody Map<String,Integer> map ){
        if(map.get("id") == null) return ResponseEntity.badRequest().body("restaurant_Id is required");
        return  ResponseEntity.ok().body(menuItemsService.getMenuItemByID(map.get("id")));
    }
}
