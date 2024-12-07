package com.airline.app;
import java.util.*;
public class ClientAppication {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Admin admin=new Admin();
		AdminPanel adPanel=new AdminPanel();

		do
		{
			System.out.println("1. ADMIN LOGIN");
			System.out.println("2. USER LOGIN");
			System.out.println("Enter the Choice");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				boolean b=admin.adminInfo();
				if(b)
				{
					adPanel.adminPanel();
				}
				else
				{
					System.out.println("Please Enter the Correct UserName And Password");
					admin.adminInfo();
				}
				break;
			case 2:
				break;
			case 3:
				System.exit(0);
				default :
					System.out.println("InValid Input");
			}
			
		}while(true);
	}

}
