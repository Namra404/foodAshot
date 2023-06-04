package com.example.foodDelivery_server.entity;

public class OrderItemEntity {

    public int basket_id;
    public int id;
    public int quantity;
    public int price;
    public String created_at;
    public String updated_at;
    public String menu_items_img;
    public String name;
    public String description;
    public int menu_category_id;
    public int restaurant_id;

    public OrderItemEntity(int basket_id, int id, int quantity, int price, String created_at, String updated_at, String menu_items_img, String name, String description, int menu_category_id, int restaurant_id) {
        this.basket_id = basket_id;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.menu_items_img = menu_items_img;
        this.name = name;
        this.description = description;
        this.menu_category_id = menu_category_id;
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        return "OrderItemEntity{" +
                "id=" + id +
                ", basket_id=" + basket_id +
                ", id=" +id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", menu_items_img='" + menu_items_img + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", menu_category_id=" + menu_category_id +
                ", restaurant_id=" + restaurant_id +
                '}';
    }
}
