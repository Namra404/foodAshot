package com.example.foodDelivery_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantCategoryService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Long> restaurantIncludeCategory(Integer... categoriesID){
        List<Integer> defaultCategoriesList = new ArrayList<>();
        String res;
        if(categoriesID != null){
            defaultCategoriesList = List.of(categoriesID);
            res = String.join(",", defaultCategoriesList.stream().map(Object::toString).toArray(String[]::new));
        }
        else{
            defaultCategoriesList.add(1);
            defaultCategoriesList.add(2);
            defaultCategoriesList.add(3);
            defaultCategoriesList.add(4);
            defaultCategoriesList.add(5);
            defaultCategoriesList.add(6);
            defaultCategoriesList.add(7);
            defaultCategoriesList.add(8);
            defaultCategoriesList.add(9);
            defaultCategoriesList.add(10);
            res = String.join(",", defaultCategoriesList.stream().map(Object::toString).toArray(String[]::new));
        }

        System.out.println(res);

        String sql = "SELECT DISTINCT r.id FROM restaurants r INNER JOIN restaurants_category rc ON r.id = rc.id_restaurant WHERE rc.id_category IN (" + res +")";
        System.out.println(sql);
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong("id"));
    }
}
