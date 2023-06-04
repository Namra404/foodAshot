package com.example.foodDelivery_server.entity;

import java.util.List;

public class RestaurantInfoEntity {
    public Long id;
    public String name;
    public String description;
    public String phone;
    public String adress;
    public int delivery_fee;
    public int minimum_order_amount;
    public String restaurant_img;
    public int number_of_views;
    public List<MenuItemsEntity> menu_items;

    public RestaurantInfoEntity(Long id, String name, String description, String phone, String adress, int delivery_fee, int minimum_order_amount, String restaurant_img, List<MenuItemsEntity> menu_items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.adress = adress;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
        this.menu_items = menu_items;
    }

    public RestaurantInfoEntity(Long id, String name, String description, String phone, String adress, int delivery_fee, int minimum_order_amount, String restaurant_img, int number_of_views, List<MenuItemsEntity> menu_items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.adress = adress;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
        this.number_of_views = number_of_views;
        this.menu_items = menu_items;
    }
}
