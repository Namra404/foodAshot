package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.RestaurantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    RestaurantCategoryService restaurantCategoryService;

//    public List<RestaurantEntity> getAllResrtaurants(){
//        String sql = "SELECT * FROM restaurants";
//
//        return jdbcTemplate.query(sql,(rs,rowNum) -> new RestaurantEntity(
//                rs.getLong("id"),
//                rs.getString("name"),
//                rs.getString("description"),
//                rs.getString("phone"),
//                rs.getString("address"),
//                rs.getInt("delivery_fee"),
//                rs.getInt("minimum_order_amount"),
//                rs.getString("restaurant_img")
//        ));
//    }
    public List<RestaurantEntity> getAllResrtaurants(Integer... catId){
        if(catId.length == 0) catId = Arrays.copyOf(new Integer[]{1, 2, 3, 4, 5,6,7,8,9,10}, 10);
        List<Long> sortRest = new ArrayList<>(restaurantCategoryService.restaurantIncludeCategory(catId));
       String res = String.join(",", sortRest.stream().map(Object::toString).toArray(String[]::new));


        String sql = "SELECT * FROM restaurants WHERE id IN (" + res+ ")" + " and active = 1 order by number_of_views desc";

        return jdbcTemplate.query(sql,(rs,rowNum) -> new RestaurantEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getInt("delivery_fee"),
                rs.getInt("minimum_order_amount"),
                rs.getString("restaurant_img"),
                rs.getInt("number_of_views")
        ));
    }

}
