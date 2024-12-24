package com.airline.user.repo;

import java.sql.SQLException;

import com.ariline.config.DBConfig;

public class UserLoginRepo extends DBConfig {
	public int validateUserRepo(String email, String password)
	{
		int uid=0;
		try 
		{
			stmt = conn.prepareStatement("select * from userinfo where email = ? AND password = ?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			 rs = stmt.executeQuery();
			 if(rs.next()) {
				 uid=rs.getInt(1);
			 }
			 
			 return uid;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return uid;

	}
}
