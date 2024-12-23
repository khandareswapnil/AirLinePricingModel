package com.airlline.admin.operation;

import java.util.List;
import java.util.Scanner;

import com.airline.admin.service.UserOperationsServiceIMPL;
import com.airline.entity.User;
import com.airline.user.operation.UserRegistrationOperation;

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
		System.out.println("5. Serach User");
		System.out.println("6. For EXIT");
		System.out.println("Enter the Choice");
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			UserRegistrationOperation userRegisOpe=new UserRegistrationOperation();
			userRegisOpe.registerUser();
			break;
		case 2:
			list=userOpSer.isGetUser();
			System.out.println("Name\tEmail\t\tContact\t\tGender");
			list.forEach(list1->System.out.println(list1.getName()+"\t"+list1.getEmail()+"\t"+list1.getContact()+"\t"+list1.getGender()));
			break;
		case 3:
			System.out.println("Enter the Email");
			sc.nextLine();
			String email=sc.nextLine();
			boolean b=userOpSer.isDeleted(email);
			 if(b)
			 {
				 System.out.println("Deleted Sucessfully....................");
			 }
			 else
			 {
				 System.out.println("Some Problem is There.......................");
			 }
			break;
		case 4:
			System.out.println("Enter the Name :");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter the Email :");
			email=sc.nextLine();
			 b=userOpSer.isUpdateUser(name,email);
			 if(b)
			 {
				 System.out.println("Update Sucessfully...................");
			 }
			 else
			 {
				 System.out.println("Some Problem is There...................");
			 }
			break;
		case 5:
			do {
				System.out.println("1. Search By Name");
				System.out.println("2. Search By City");
				System.out.println("3. FOR EXIT");
				System.out.println("Enter the Choice");
				 int ch1=sc.nextInt();
				switch(ch1)
				{
					case 1:
						System.out.println("Enter the Name For Search :");
						sc.nextLine();
						String searchName=sc.nextLine();
						list=userOpSer.isSearchByName(searchName);
						list.forEach(list1->System.out.println(list1.getName()+"\t"+list1.getEmail()+"\t"+list1.getContact()+"\t"+list1.getGender()));
						break;
					case 2:
						System.out.println("Enter the City Name For Search :");
						sc.nextLine();
						String cityNamee=sc.nextLine();
						list=userOpSer.isSearchByCityName(cityNamee);
						list.forEach(list1->System.out.println(list1.getName()+"\t"+list1.getEmail()+"\t"+list1.getContact()+"\t"+list1.getGender()+"\t"+list1.getCityname()));
						break;
					case 3:
						break;
						default:
							System.out.println("Invalid Input");
				}
			}while(true);
			
			
		
		case 6:
			AdminPanel adminPanel=new AdminPanel();
			adminPanel.adminPanel();
			
			default:
				System.out.println("Invalid Choice Enter");
			
		}
		
		
	}while(true);
	}

}

