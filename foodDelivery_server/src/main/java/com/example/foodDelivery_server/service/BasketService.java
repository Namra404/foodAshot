package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BasketService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OrderService orderService;



    public BasketOrderInfoEntity getUserBasketInRestaurant(int user_id,int restaurant_id){
//        String sql = "select * from public.order where basket_id = (select id from basket where user_id = " + user_id +")"  + " ORDER BY id DESC LIMIT 1";
        String sql = "select * from basket where user_id = " + user_id + " and restaurant_id = " + restaurant_id  + " ORDER BY id DESC LIMIT 1" ;

        BasketOrderInfoEntity basket = (BasketOrderInfoEntity) jdbcTemplate.query(sql,(rs, rowNum) -> new BasketOrderInfoEntity(
                rs.getLong("id"),
                rs.getInt("user_id"),
                rs.getInt("restaurant_id"),
                null,
                rs.getInt("delivery_time"),
                rs.getInt("total_price"),
                rs.getInt("delivery_fee"),
                rs.getInt("status"),
                null
        )).get(0);
        basket.order = orderService.getAllOrderByBasketID(basket.id);
        return basket;
    }
    public List<BasketOrderInfoEntity> getUserBasket(int user_id){
        String sql = "select basket.id,user_id,restaurants.name,order_time, delivery_time,total_price,basket.delivery_fee,basket.status,basket.created_at,basket.updated_at from basket  join restaurants on restaurant_id = restaurants.id  where user_id = " + user_id ;

        List<BasketOrderInfoEntity> baskets = (List<BasketOrderInfoEntity>) jdbcTemplate.query(sql,(rs, rowNum) -> new BasketOrderInfoEntity(
                rs.getLong("id"),
                rs.getInt("user_id"),
                rs.getString("name"),
                rs.getString("order_time"),
                rs.getInt("delivery_time"),
                rs.getInt("total_price"),
                rs.getInt("delivery_fee"),
                rs.getInt("status"),
                null
        ));
        System.out.println(baskets);
        for (BasketOrderInfoEntity basket: baskets) {
            basket.order = orderService.getAllOrderByBasketID(basket.id);
        }
        return baskets;
    }
    public void createBasket(int user_id, RestaurantEntity restaurant, List<OrderItemEntity> orders){
        String sql = "INSERT INTO public.basket(user_id, restaurant_id, order_time, delivery_time, total_price, delivery_fee, status)" +
        "VALUES (?,?,?,?,?,?,?)";
        String sql2 ="SELECT * FROM public.basket where user_id = " + user_id + " and restaurant_id = " + restaurant.id  + " ORDER BY id DESC LIMIT 1";
        jdbcTemplate.update(sql,user_id,restaurant.id,new Date(), 60, 1, restaurant.delivery_fee,1);
       BasketEntity basket =  jdbcTemplate.query(sql2,(rs, rowNum) -> new BasketEntity(
                rs.getLong("id"),
                rs.getInt("user_id"),
                rs.getInt("restaurant_id"),
                rs.getString("order_time"),
                rs.getInt("delivery_time"),
                rs.getInt("total_price"),
                rs.getInt("delivery_fee"),
                rs.getInt("status")
        )).get(0);

      int total_sum = orderService.addOrders(orders,basket.id);
      updateTotalSum(basket.id,total_sum);

    }

    public void updateTotalSum(Long basket_id, int total_sum){
        String sql = "UPDATE public.basket SET total_price= ? WHERE id = ?";
        jdbcTemplate.update(sql, total_sum, basket_id);
    }

//    public List<BasketEntity> getAllUserBaskets(int user_id){
//        String sql = "SELECT * FROM public.basket WHERE user_id = ? AND restaurant_id IN (SELECT id FROM restaurants)";
//        return jdbcTemplate.query(sql,((rs, rowNum) -> rs.getLong("id")
//
//    }
}
