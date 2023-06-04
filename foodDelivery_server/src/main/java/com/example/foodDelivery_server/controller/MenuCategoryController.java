package com.example.foodDelivery_server.controller;

import com.example.foodDelivery_server.entity.MenuCategoryEntity;
import com.example.foodDelivery_server.service.MenuCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")

public class MenuCategoryController {
    @Autowired
    MenuCategoryService menuCategoryService;
    @GetMapping("/menuCategory")
    public ResponseEntity getAllMenuCategory(){
        List<MenuCategoryEntity> mce = menuCategoryService.getCategories();
        return ResponseEntity.ok().body(mce);
    }
}
