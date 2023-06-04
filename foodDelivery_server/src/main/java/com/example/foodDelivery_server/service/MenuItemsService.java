package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.MenuItemsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MenuItemsEntity> getAllMenuItemsByRestaurantID(int restaurant_id){
        String sql = "select * from menu_items where restaurant_id =" + restaurant_id ;

        return jdbcTemplate.query(sql, (rs, rowNum) -> new MenuItemsEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getInt("menu_category_id"),
                rs.getInt("restaurant_id"),
                rs.getString("menu_items_img")
        ));
    }

    public MenuItemsEntity getMenuItemByID(int menu_item_id){
        String sql = "select * from menu_items where id =" + menu_item_id;
        return jdbcTemplate.query(sql,(rs, rowNum) -> new MenuItemsEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getInt("price"),
                rs.getInt("menu_category_id"),
                rs.getInt("restaurant_id"),
                rs.getString("menu_items_img")
        )).get(0);
    }
    public void addMenuItem(MenuItemsEntity menuItem){
        String sql = "INSERT INTO public.menu_items(name, description, price, menu_category_id, restaurant_id,menu_items_img) VALUES (?, ?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql,menuItem.name,menuItem.description,menuItem.price,menuItem.menu_category_id,menuItem.restaurant_id,menuItem.menu_items_img);
    }
}
