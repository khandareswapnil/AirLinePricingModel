package com.airline.app;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.UserOperationsServiceIMPL;
import com.airline.entity.User;

public class AddUserByAdmin {
	Scanner sc=new Scanner(System.in);
	User user=new User();
	UserOperationsServiceIMPL userOpSer=new UserOperationsServiceIMPL();
	List<User> list;
	public String userOperation()
	{
	do
	{
		System.out.println("1. Add the User");
		System.out.println("2. View User");
		System.out.println("3. Delete the User");
		System.out.println("4. Update The User ");
		System.out.println("5. Serach User By Name");
		System.out.println("6. For EXIT");
		System.out.println("Enter the Choice");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter the Name");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter the Email");
			String email=sc.nextLine();
			System.out.println("Enter the Contact Number");
			String contact=sc.nextLine();
			System.out.println("Enter the Gender");
			String gender=sc.nextLine();
			System.out.println("Enter the Password");
			String password=sc.nextLine();
			
			user.setName(name);
			user.setEmail(email);
			user.setContact(contact);
			user.setGender(gender);
			user.setPassword(password);
			
			boolean b=userOpSer.isAddUser(user);
			if(b)
			{
				System.out.println("User Added Sucess");
			}
			else
			{
				System.out.println("Some Problem is There from User Add By Admin");
			}
			break;
		case 2:
			list=userOpSer.isGetUser();
			System.out.println("Name\tEmail\t\tContact\t\tGender");
			list.forEach(list1->System.out.println(list1.getName()+"\t"+list1.getEmail()+"\t"+list1.getContact()+"\t"+list1.getGender()));
			break;
		case 3:
			System.out.println("Enter the Email");
			sc.nextLine();
			email=sc.nextLine();
			b=userOpSer.isDeleted(email);
			 if(b)
			 {
				 System.out.println("Deleted Sucessfully");
			 }
			 else
			 {
				 System.out.println("Some Problem is There");
			 }
			break;
		case 4:
			System.out.println("Enter the Name");
			sc.nextLine();
			name=sc.nextLine();
			System.out.println("Enter the Email");
			email=sc.nextLine();
			 b=userOpSer.isUpdateUser(name,email);
			 if(b)
			 {
				 System.out.println("Update Sucessfully");
			 }
			 else
			 {
				 System.out.println("Some Problem is There");
			 }
			break;
		case 5:
			System.out.println("Enter the Name For Search");
			sc.nextLine();
			String searchName=sc.nextLine();
			list=userOpSer.isSearchByName(searchName);
			list.forEach(list1->System.out.println(list1.getName()+"\t"+list1.getEmail()+"\t"+list1.getContact()+"\t"+list1.getGender()));
			
			break;
		case 6:
			System.exit(0);
			break;
			default:
				System.out.println("Invalid Choice Enter");
			
		}
		
		
	}while(true);
	}

}

