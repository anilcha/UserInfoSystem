package com.vastika.userinfosystem.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.userinfosystem.util.DbConnection;

public class CreateUserInfoDb {
	
	final static String SQL = "create database user_form_db";

		public static void main(String[] args) {
			try (
					Connection con = DbConnection.getConnection();
					PreparedStatement ps = con.prepareStatement(SQL);){	
					ps.executeUpdate();
					
					System.out.println("Database created successfully");	
				
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	}
}
