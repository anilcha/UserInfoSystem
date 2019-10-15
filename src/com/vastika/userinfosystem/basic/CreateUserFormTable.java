package com.vastika.userinfosystem.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.userinfosystem.util.DbConnection;

public class CreateUserFormTable {
	
	final static String SQL = "create table user_form_db.user_form_tbl(id int not null auto_increment, user_name varchar(50) null, password varchar(50) null, email varchar(50) null, gender_male varchar (20) null, gender_female varchar(25) null, reading_box varchar(10) null, playing_box varchar(10) null, nationality varchar(40)null, dob Date, primary key(id))";
	
	public static void main(String[] args) {
		
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL);){	
				ps.executeUpdate();
				
				System.out.println("Table Created successfully");

				con.close();
				ps.close();		
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
