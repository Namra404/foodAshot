package com.example.foodDelivery_server.entity;

public class RestaurantEntity {
    public Long id;
    public String name;
    public String description;
    public String phone;
    public String address;
    public int delivery_fee;
    public int minimum_order_amount;
    public String restaurant_img;
    public int number_of_views;
    public int active;

    public RestaurantEntity(Long id, String name, String description, String phone, String address, int delivery_fee, int minimum_order_amount, String restaurant_img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
    }

    public RestaurantEntity(Long id, String name, String description, String phone, String address, int delivery_fee, int minimum_order_amount, String restaurant_img, int number_of_views) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
        this.number_of_views = number_of_views;
    }

    public RestaurantEntity(String name, String description, String phone, String address, int delivery_fee, int minimum_order_amount, String restaurant_img, int number_of_views) {
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
        this.number_of_views = number_of_views;
    }

    public RestaurantEntity(String name, String description, String phone, String address, int delivery_fee, int minimum_order_amount, String restaurant_img) {
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
    }
    public RestaurantEntity(){
    }

    public RestaurantEntity(Long id, String name, String description, String phone, String address, int delivery_fee, int minimum_order_amount, String restaurant_img, int number_of_views, int active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.address = address;
        this.delivery_fee = delivery_fee;
        this.minimum_order_amount = minimum_order_amount;
        this.restaurant_img = restaurant_img;
        this.number_of_views = number_of_views;
        this.active = active;
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", delivery_fee=" + delivery_fee +
                ", minimum_order_amount=" + minimum_order_amount +
                ", restaurant_img='" + restaurant_img + '\'' +
                ", number_of_views=" + number_of_views +
                ", active =" + active+
                '}';
    }
}
