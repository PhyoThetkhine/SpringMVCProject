package com.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.model.LoginBean;
import com.spring.model.UserBean;


@Repository
public class UserRepository {
	
	
	public int insertUser(UserBean bean) {
		int i = 0;
		 Connection con= UserConnection.getConnection();
		 String sql = "insert into user(name,email,password,role) values(?,?,?,'user')";
		 try {
			 PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			
			i=ps.executeUpdate();
		
		} catch (SQLException e) {
		System.out.println("Insert error:" +e.getMessage());
		
		}
		return i;
	}
	
	
	public boolean checkEmail(String email) {
		boolean check=false;
		Connection con = UserConnection.getConnection();
		String sql ="select * from user where email = ?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				check=true;
			}
			
		} catch (SQLException e) {
			System.out.println("Check email:"+e.getMessage());
		}
		
		return check;
		
		
	}
	public UserBean loginUser(LoginBean bean) {
		UserBean user = null;
		Connection con = UserConnection.getConnection();
		String sql ="select * from user where email = ? and password = ?";
		 try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			ps.setString(2,bean.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("Login user "+e.getMessage());
			
		}
		
		return user;
		
		
	}
	

}
