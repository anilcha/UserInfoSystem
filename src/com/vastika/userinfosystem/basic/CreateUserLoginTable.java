package com.vastika.userinfosystem.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.userinfosystem.util.DbConnection;

public class CreateUserLoginTable {
	
	final static String SQL = "create table user_login (user_id varchar(40) not null, user_name varchar(50) null, password varchar(50) null, primary key(user_id))";
	
	public static void main(String[] args) {
		
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL);
				){
			ps.executeUpdate();
			System.out.println("User Login Table created successfully");
			
			con.close();
			ps.close();
			
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}
	}
}
