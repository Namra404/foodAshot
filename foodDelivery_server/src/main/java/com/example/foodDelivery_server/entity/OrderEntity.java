package com.example.foodDelivery_server.entity;

import java.util.List;

public class OrderEntity {
    public Long id;
    public int basket_id;
    public int menu_item_id;
    public int quantity;
    public int price;
    public String created_at;
    public String updated_at;

    public MenuItemsEntity menuItemsEntity;


    public OrderEntity(Long id, int basket_id, int menu_item_id, int quantity, int price, MenuItemsEntity menuItemsEntity) {
        this.id = id;
        this.basket_id = basket_id;
        this.menu_item_id = menu_item_id;
        this.quantity = quantity;
        this.price = price;
        this.menuItemsEntity = menuItemsEntity;
    }

    public OrderEntity(Long id, int basket_id, int menu_item_id, int quantity, int price, String created_at, String updated_at) {
        this.id = id;
        this.basket_id = basket_id;
        this.menu_item_id = menu_item_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public OrderEntity( int menu_item_id, int quantity, int price) {
        this.menu_item_id = menu_item_id;
        this.quantity = quantity;
        this.price = price;
    }




}
