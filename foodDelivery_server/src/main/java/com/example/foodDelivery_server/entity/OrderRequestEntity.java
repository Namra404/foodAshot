package com.example.foodDelivery_server.entity;

import java.util.List;

public class OrderRequestEntity {
    public List<OrderItemEntity> items;
    public int user_id;
    public int restaurant_id;


    public OrderRequestEntity(List<OrderItemEntity> items, int user_id, int restaurant_id) {
        this.items = items;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "OrderRequestEntity{" +
                "items=" + items +
                ", user_id=" + user_id +
                ", restaurant_id=" + restaurant_id +
                '}';
    }
}
