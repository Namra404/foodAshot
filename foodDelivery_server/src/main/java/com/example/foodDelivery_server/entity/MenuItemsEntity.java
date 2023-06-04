package com.example.foodDelivery_server.entity;

public class MenuItemsEntity {
    public Long id;
    public String name;
    public String description;
    public int price;
    public int menu_category_id;
    public int restaurant_id;
    public String menu_items_img;
    public String created_at;
    public String updated_at;



    public MenuItemsEntity(Long id, String name, String description, int price, int menu_category_id, int restaurant_id, String menu_item_img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menu_category_id = menu_category_id;
        this.restaurant_id = restaurant_id;
        this.menu_items_img = menu_item_img;
    }


    public MenuItemsEntity(Long id, String name, String description, int price, int menu_category_id, int restaurant_id, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.menu_category_id = menu_category_id;
        this.restaurant_id = restaurant_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public MenuItemsEntity(String name, String description, int price, int menu_category_id, int restaurant_id, String menu_items_img) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.menu_category_id = menu_category_id;
        this.restaurant_id = restaurant_id;
        this.menu_items_img = menu_items_img;
    }

    public MenuItemsEntity() {
    }
}
