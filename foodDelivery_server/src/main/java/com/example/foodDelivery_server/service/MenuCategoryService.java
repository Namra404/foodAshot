package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.MenuCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.dialect.HsqlDbDialect;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuCategoryService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<MenuCategoryEntity> getCategories(){
        String sql = "SELECT * FROM menu_category";
        return jdbcTemplate.query(sql,(rs,rowNum) -> new MenuCategoryEntity(
                rs.getLong("id"),
                rs.getString("name")
        ));
    }
    public List<Long> getCategorieByID(Integer... catId){
        List<Integer> defaultCategoriesList = new ArrayList<>();

        String res ;
        if(catId != null){
            defaultCategoriesList = List.of(catId);
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
        String sql = "SELECT * FROM menu_category where id in (" + res + ")";
        return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getLong("id"));
    }
}
