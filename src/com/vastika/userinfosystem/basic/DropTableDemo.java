package com.vastika.userinfosystem.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.userinfosystem.util.DbConnection;

public class DropTableDemo {
	
	final static String SQL = "drop table demo_db.login_tbl_";

	public static void main(String[] args) {
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL);){	
				ps.executeUpdate();
				
				System.out.println("Table Dropped successfully");	
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
