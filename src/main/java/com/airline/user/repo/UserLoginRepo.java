package com.airline.user.repo;

import java.sql.SQLException;

import com.ariline.config.DBConfig;

public class UserLoginRepo extends DBConfig {
	public boolean validateUserRepo(String email, String password)
	{
		try 
		{
			stmt = conn.prepareStatement("select * from userinfo where email = ? AND password = ?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			 rs = stmt.executeQuery();
			 
			 return rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;

	}
}
