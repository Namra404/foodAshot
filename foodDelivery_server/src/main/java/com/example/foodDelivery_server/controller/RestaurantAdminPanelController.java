package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.service.RestaurantAdminPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RestaurantAdminPanelController {
    @Autowired
    RestaurantAdminPanelService restaurantAdminPanelService;

    @PostMapping("/getRestaurantAdmin")
    public ResponseEntity getRestaurantAdmin(@RequestBody Integer user_id){
        if(restaurantAdminPanelService.isAdmin(user_id)){
            return ResponseEntity.ok().body(restaurantAdminPanelService.getRestaurantAdmin(user_id));
        }
        else {
            return ResponseEntity.badRequest().body("не админ");
        }
    }

}
