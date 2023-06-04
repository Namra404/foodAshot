package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.Exeptions.IsRestaurantExistExeption;
import com.example.foodDelivery_server.Exeptions.isUserExistExeption;
import com.example.foodDelivery_server.entity.MenuItemsEntity;
import com.example.foodDelivery_server.entity.RestaurantEntity;
import com.example.foodDelivery_server.entity.UserEntity;
import com.example.foodDelivery_server.service.AdminService;
import com.example.foodDelivery_server.service.MenuItemsService;
import com.example.foodDelivery_server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    MenuItemsService menuItemsService;


    @PostMapping("/restaurant/create")
    public ResponseEntity createRestaurant(@RequestBody RestaurantEntity restaurant){
        try {
            restaurantService.createRestaurant(restaurant);
            System.out.println(restaurant +"REGISTRATION");
            return ResponseEntity.ok("ok");
        }catch (IsRestaurantExistExeption e){
            return ResponseEntity.badRequest().body("Не удалось создать ресторан");
        }
    }

    @PostMapping("/restaurant/changeStatus")
    public ResponseEntity changeRestaurantStatus(@RequestBody Map<String,Integer> map){
        if(map.get("id") == null || map.get("status" )== null) return ResponseEntity.badRequest().body("Id is required");
        restaurantService.changeRestaurantStatus(map.get("id"), map.get("status"));
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/restaurant/addMenuItem")
    public ResponseEntity addMenuItem(@RequestBody MenuItemsEntity menuItem){
        menuItemsService.addMenuItem(menuItem);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/restaurant/getRestaurantByName")
    public ResponseEntity getRestaurantByName(@RequestBody Map<String,String> map){
        if(map.get("name") == null) return ResponseEntity.badRequest().body("Name is null");
        return ResponseEntity.ok().body(restaurantService.getRestaurantByName(map.get("name")));
    }

}
