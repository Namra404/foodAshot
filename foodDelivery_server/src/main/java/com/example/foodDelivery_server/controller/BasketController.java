package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.Exeptions.isUserExistExeption;
import com.example.foodDelivery_server.entity.OrderEntity;
import com.example.foodDelivery_server.entity.OrderItemEntity;
import com.example.foodDelivery_server.entity.OrderRequestEntity;
import com.example.foodDelivery_server.entity.RestaurantEntity;
import com.example.foodDelivery_server.service.BasketService;
import com.example.foodDelivery_server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BasketController {
    @Autowired
    BasketService basketService;
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/getUserBasket/info")
    public ResponseEntity getUserBasketInfo(@RequestBody Map<String, Integer> map) {
        if (map.get("user_id") == null) return ResponseEntity.badRequest().body("restaurant_Id is required");
        return ResponseEntity.ok().body(basketService.getUserBasket(map.get("user_id")));
    }

    @PostMapping("/basket")
    public ResponseEntity addToBasket(@RequestBody Map<String, OrderRequestEntity> map) {
        OrderRequestEntity data = map.get("data");
        List<OrderItemEntity> items = data.items;
        System.out.println(items);
        int user_id = data.user_id;
        int res_id = data.restaurant_id;
        RestaurantEntity restaurant = restaurantService.getRestaurant(res_id);
        basketService.createBasket(user_id,restaurant,items);
        return ResponseEntity.ok().body("dfs");
    }

    @PostMapping("/getUserBasketInRestaurant/info")
    public ResponseEntity getUserBasketInRestaurant(@RequestBody Map<String, Integer> map) {
        if (map.get("user_id") == null) return ResponseEntity.badRequest().body("restaurant_Id is required");
        return ResponseEntity.ok().body(basketService.getUserBasketInRestaurant(map.get("user_id"),map.get("restaurant_id")));
    }

}
