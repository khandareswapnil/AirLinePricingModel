package com.airline.admin.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.User;
import com.ariline.config.DBConfig;

public class UserOperationRepoIMPL extends DBConfig implements UserOperationRepo {
	User user=new User();
	@Override
	public boolean isAddUser(User user) {
		try {
		stmt=conn.prepareStatement("Insert into userInfo values('0',?,?,?,?,?)");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getEmail());
		stmt.setString(3, user.getContact());
		stmt.setString(4, user.getPassword());
		stmt.setString(5, user.getGender());
		
		int res=stmt.executeUpdate();		
		return res>0?true:false;
		}catch(Exception exc)
		{
			System.out.println("Error is"+exc);
		}
		return false;
	}

	@Override
	public List<User> isGetUser() {
		try {
			stmt=conn.prepareStatement("Select *from userInfo");
		 rs=stmt.executeQuery();
		 List<User> list=new ArrayList<>();
		 while(rs.next())
		 {
			User user=new User();
			 user.setName(rs.getString(2));
			 user.setEmail(rs.getString(3));
			 user.setContact(rs.getString(4));
			 user.setGender(rs.getString(6));
			 list.add(user);
			
		 }
		 
		 return list;
		}catch(Exception ex)
		{
			System.out.println("error is ex");
		}
		
		return null;
	}
	@Override
	public boolean isUpdateUser(String name,String email) {
		try
		{
			stmt=conn.prepareStatement("update userInfo set name=? where email=?");
			stmt.setString(1, name);
			stmt.setString(2,email);
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	@Override
	public boolean isDeleted(String email) {
		try
		{
			stmt=conn.prepareStatement("delete from userInfo where email=?");
			stmt.setString(1, email);
			int val=stmt.executeUpdate();
			return val>0?true:false;
		}catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
		return false;
	}
	@Override
	public List<User> isSearchByName(String name) {
		try {
			stmt=conn.prepareStatement("select * from userInfo where name=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			List<User> list=new ArrayList<>();
			while(rs.next())
			{
				user=new User();
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setContact(rs.getString(4));
				user.setGender(rs.getString(6));
				list.add(user);
				
			}
			return list;
			
			
		}catch(Exception ex)
		{
			System.out.println("Some Problem is There");
		}
		return null;
	}

}
