package com.vastika.userinfosystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vastika.userinfosystem.model.Login;
import com.vastika.userinfosystem.util.DbConnection;

public class LoginDaoImpl implements LoginDao {
	
	public static String SQL = "insert into user_login(user_id, user_name, password) values (?,?,?)";

	@Override
	public int saveLogin(Login login) {
		int saved = 0;
		
		try (
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL);){
			ps.setString(1, login.getUser_id());
			ps.setString(2, login.getUser_name());
			ps.setString(3, login.getPassword());
			
			saved = ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace();
		}		
		return saved;
	}
} 
 
                     
