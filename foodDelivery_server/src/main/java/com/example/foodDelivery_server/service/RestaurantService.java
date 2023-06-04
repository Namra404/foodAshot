package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.Exeptions.IsRestaurantExistExeption;
import com.example.foodDelivery_server.Exeptions.isUserExistExeption;
import com.example.foodDelivery_server.entity.MenuItemsEntity;
import com.example.foodDelivery_server.entity.RestaurantEntity;
import com.example.foodDelivery_server.entity.RestaurantInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired MenuItemsService menuItemsService;


    //Это достояние!!!
    public RestaurantInfoEntity getRestaurantInfo(int id) {
        String sql = "SELECT * FROM restaurants as r where r.id = " + id;

        List<MenuItemsEntity> menu_items = menuItemsService.getAllMenuItemsByRestaurantID(id);

        RestaurantInfoEntity info = (RestaurantInfoEntity) jdbcTemplate.query(sql, (rs, rowNum) -> new RestaurantInfoEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getInt("delivery_fee"),
                rs.getInt("minimum_order_amount"),
                rs.getString("restaurant_img"),
                rs.getInt("number_of_views"),
                null
        )).get(0);

        info.menu_items = menu_items;
        return info;
    }
    public RestaurantEntity getRestaurant(int id) {
        String sql = "SELECT * FROM restaurants where id = " + id;


        return jdbcTemplate.query(sql, (rs, rowNum) -> new RestaurantEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getInt("delivery_fee"),
                rs.getInt("minimum_order_amount"),
                rs.getString("restaurant_img"),
                rs.getInt("number_of_views")
        )).get(0);
    }
    public void addViewToRestaurant(int id){
        String sql = "UPDATE public.restaurants SET number_of_views= number_of_views + 1 WHERE id = " + id;
        jdbcTemplate.update(sql);
    }

    public String getRestaurantByName(String name){
        String sql="SELECT * FROM restaurants WHERE name = ?";
        RestaurantEntity restaurant = jdbcTemplate.query(sql, (rs, rowNum) -> new RestaurantEntity(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getInt("delivery_fee"),
                rs.getInt("minimum_order_amount"),
                rs.getString("restaurant_img"),
                rs.getInt("number_of_views"),
                rs.getInt("active")
        ),name).get(0);
         return restaurant.toString();
    }
    public void createRestaurant(RestaurantEntity restaurant) throws IsRestaurantExistExeption {
        if(isRestaurantExist(restaurant.name)){
            throw new IsRestaurantExistExeption("ресторан с таким именем уже существует");
        }
        else {
            String sql = "INSERT INTO public.restaurants(name, description, phone, address, delivery_fee, minimum_order_amount, restaurant_img, number_of_views) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            jdbcTemplate.update(sql,restaurant.name,restaurant.description,restaurant.phone,restaurant.address,restaurant.delivery_fee,restaurant.minimum_order_amount,restaurant.restaurant_img,restaurant.number_of_views);
        }
    }
    public boolean isRestaurantExist(String name){
        String sql = "SELECT COUNT(*) FROM public.restaurants WHERE restaurants.name = E'" + name+"'";
        return jdbcTemplate.queryForObject(sql, Integer.class) != 0;
    }
    public void changeRestaurantStatus(int id, int status){
        String sql = "UPDATE public.restaurants SET active= ? WHERE restaurants.id = ?;";
        jdbcTemplate.update(sql,status,id);
    }

}
