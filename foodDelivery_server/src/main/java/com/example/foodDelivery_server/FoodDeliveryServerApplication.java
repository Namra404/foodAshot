package com.example.foodDelivery_server;

import com.example.foodDelivery_server.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FoodDeliveryServerApplication {

	public static void main(String[] args) throws SQLException, IllegalAccessException, ClassNotFoundException {
		SpringApplication.run(FoodDeliveryServerApplication.class, args);

	}

//	public static List<UserEntity> getAllUsers() throws SQLException, IllegalAccessException, ClassNotFoundException {
//		String dbanme = "food_delivery";
//		String PGuser = "postgres";
//		String passw = "123";
//		Class.forName("org.postgresql.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbanme +PGuser + passw);
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery("SELECT * from users");
//		List<UserEntity> users = new ArrayList<>();
//		while (rs.next()){
//			UserEntity user = new UserEntity();
//			for (Field f: user.getClass().getDeclaredFields()) {
//				f.setAccessible(true);
//				String columnName = f.getName();
//				Object value = rs.getObject(columnName);
//				f.set(user,value);
//			}
//			users.add(user);
//		}
//		return users;
//	}
}
