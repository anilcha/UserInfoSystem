package com.vastika.userinfosystem.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.userinfosystem.model.User;
import com.vastika.userinfosystem.util.DbConnection;


public class UserDaoImpl implements UserDao{
	
	public static final String INSERT_SQL = "insert into user_form_db.user_form_tbl(user_name, password, email, gender, hobbies, nationality, dob) values(?,?,?,?,?,?,?)";
	public static final String UPDATE_SQL = "update user_form_tbl set user_name=?, password=?, email=?, gender=?, hobbies=?, nationality=?, dob=? where id =?";
	public static final String SELECT_SQL = "select * from user_form_db.user_form_tbl";
	public static final String DELETE_SQL = "delete from user_form_tbl where id=?";
	
	@Override
	public int saveUser(User user) {										// creating method for save
		int saved = 0;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_SQL);
				){
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getHobbies());
			ps.setString(6, user.getNationality());
			ps.setDate(7, new Date(user.getDob().getTime()));
			saved = ps.executeUpdate();
			
		}catch ( ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}	
		return saved;
	}
	
	@Override
	public int updateUser(User user) {										// creating method for update
		int updated = 0;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_SQL);
				){
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getHobbies());
			ps.setString(6, user.getNationality());
			ps.setDate(7, new Date(user.getDob().getTime()));
			ps.setInt(8, user.getId());
			updated = ps.executeUpdate();
			
		}catch ( ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}	
		return updated;
	}
	
	@Override
	public List<User> getAllUserInfo() {										// creating method for populating data in the table								
		List<User> userList = new ArrayList<>();
		
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_SQL);){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setHobbies(rs.getString("hobbies"));
				user.setNationality(rs.getString("nationality"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);			
				
			}		
		
	}catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
		return userList;
}

	@Override
	public void deleteUserInfo(int id) {											// creating method for deleting the data
		
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_SQL);
				){
				ps.setInt(1, id);
				ps.executeUpdate();
		
	}catch(SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}

	}		
}
	
	
	
	
	
	
	
