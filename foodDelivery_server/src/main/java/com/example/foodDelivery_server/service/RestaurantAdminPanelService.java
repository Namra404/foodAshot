package com.example.foodDelivery_server.service;

import com.example.foodDelivery_server.entity.RestaurantAdminPanelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantAdminPanelService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean isAdmin(Integer user_id){
        System.out.println("isAD" + user_id);
        String sql = "SELECT COUNT(*) FROM restaurant_admin_panel WHERE user_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, user_id);
        return count != null && count > 0;
    }

    public RestaurantAdminPanelEntity getRestaurantAdmin(Integer user_id){
        return jdbcTemplate.query("SELECT * FROM restaurant_admin_panel WHERE user_id = ?",
                (rs,rowNum) -> new RestaurantAdminPanelEntity(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("payment_address")
                ),user_id
        ).get(0);
    }


}
