package com.example.foodDelivery_server.entity;

public class BasketEntity {
    public Long id;
    public int user_id ;
    public int restaurant_id;
    public String order_time;
    public int delivery_time;
    public int total_price;
    public int delivery_fee;
    public int status;
    public String created_at;
    public String updated_at;

    public BasketEntity(Long id, int user_id, int restaurant_id, String order_time, int delivery_time, int total_price, int delivery_fee, int status, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.order_time = order_time;
        this.delivery_time = delivery_time;
        this.total_price = total_price;
        this.delivery_fee = delivery_fee;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public BasketEntity(Long id, int user_id, int restaurant_id, String order_time, int delivery_time, int total_price, int delivery_fee, int status) {
        this.id = id;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.order_time = order_time;
        this.delivery_time = delivery_time;
        this.total_price = total_price;
        this.delivery_fee = delivery_fee;
        this.status = status;
    }

}

