package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.MenuItemsEntity;
import com.example.foodDelivery_server.entity.OrderEntity;
import com.example.foodDelivery_server.entity.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MenuItemsService menuItemsService;



    public List<OrderEntity> getAllOrderByBasketID(Long basket_id){
       String sql = "select * from public.order where basket_id = " + basket_id;
       List<OrderEntity> orderEntity =  jdbcTemplate.query(sql, (rs, rowNum) -> new OrderEntity(
               rs.getLong("id"),
               rs.getInt("basket_id"),
               rs.getInt("menu_item_id"),
               rs.getInt("quantity"),
               rs.getInt("price"),
               null
       ));
        for (OrderEntity order: orderEntity) {
            MenuItemsEntity menuItemsEntity = menuItemsService.getMenuItemByID(order.menu_item_id);
            order.menuItemsEntity = menuItemsEntity;
        }

       return orderEntity;
    }

    public int addOrders(List<OrderItemEntity> orders, Long basket_id){
        int totalSum = 0;
        for (OrderItemEntity order: orders) {
          String sql =   "INSERT INTO public.order( basket_id, menu_item_id, quantity, price) VALUES (" + basket_id + "," +  order.id + "," + order.quantity + "," + order.price + ")";
          totalSum += order.price * order.quantity;
            jdbcTemplate.update(sql);
        }
      return totalSum;
    }
}

