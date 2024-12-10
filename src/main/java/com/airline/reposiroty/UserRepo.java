package com.airline.reposiroty;
import java.sql.SQLException;
import java.util.*;
import com.airline.entity.User;
public class UserRepo extends DbConfig {
	
	public boolean registerUser(User user) {
		try 
		{
			stmt = conn.prepareStatement ("insert into users (name, email, contact, gender, password) values (?, ?, ?, ?, ?)");
			stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getContact());
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getPassword());
            int val=stmt.executeUpdate();
            if(val!=0)
            {
            	return true;
            }
            else
            {
            	return false;
            }
	    }
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
	
	public boolean validateUser(String email, String password)
	{
		try 
		{
			stmt = conn.prepareStatement("select *from users where email = ? AND password = ?");
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
	
	public ArrayList<User> getAllUsers()
	{
		ArrayList<User> list = new ArrayList<>();
		try
		{
			stmt = conn.prepareStatement("SELECT *from users");
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setContact(rs.getString("contact"));
				user.setGender(rs.getString("Gender"));
				user.setPassword(rs.getString("password"));
				list.add(user);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
