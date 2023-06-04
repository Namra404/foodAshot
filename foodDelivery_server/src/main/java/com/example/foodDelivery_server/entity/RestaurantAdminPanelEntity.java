package com.example.foodDelivery_server.entity;

public class RestaurantAdminPanelEntity {
    public Long id;
    public int user_id ;
    public int restaurant_id;

    public String payment_address;

    public RestaurantAdminPanelEntity(Long id, int user_id, int restaurant_id, String payment_address) {
        this.id = id;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.payment_address = payment_address;
    }

    public RestaurantAdminPanelEntity(int user_id, int restaurant_id, String payment_address) {
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.payment_address = payment_address;
    }
}
