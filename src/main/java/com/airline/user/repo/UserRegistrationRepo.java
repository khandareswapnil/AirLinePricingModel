package com.airline.user.repo;

import com.airline.entity.User;
import com.ariline.config.DBConfig;

public class UserRegistrationRepo extends DBConfig{
	public boolean registerUserRepo(User user)
	{
		try 
		{
			stmt = conn.prepareStatement ("insert into userinfo values ('0',?, ?, ?, ?,?)");
			stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getContact());
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getPassword());
            int val=stmt.executeUpdate();
           return val>0 ? true: false;
	    }
		catch(Exception ex)
		{
			System.out.println(ex);
			return false;
		}
		
	}
}
