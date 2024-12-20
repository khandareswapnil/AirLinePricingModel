package com.airlline.admin.operation;

import java.util.*;

import com.airline.app.ClientAppication;

public class AdminPanel {

	public void adminPanel() {
		ClientAppication clintApp = new ClientAppication();
		Scanner sc = new Scanner(System.in);
		System.out.println("WELOCME TO ADMIN PANEL");
		System.out.println("****************************************");
		do {
			System.out.println("1.USERS");
			System.out.println("2. City Operation");
			System.out.println("3.View Booking");
			System.out.println("4. Add Flights Details");
			System.out.println("Enter the Choice");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				AddUserByAdmin adduserbyAdmin = new AddUserByAdmin();
				adduserbyAdmin.userOperation();
				break;
			case 2:
				CityOperation startCityAdd = new CityOperation();
				startCityAdd.addStartCity();

				break;
			case 3:
				System.out.println("ENTER THE NAME OF FLIGHTS");
				sc.nextLine();
				String fname = sc.nextLine();
				System.out.println("Enter the Time Of Flights");
				int time = sc.nextInt();
				System.out.println("Enter the No Of Seats");
				int no_seats = sc.nextInt();
				System.out.println("Enter the Base Price for Per KM");
				int basePrice = sc.nextInt();

				
				break;
			case 4:
				clintApp.main(null);
				break;
			default:
				System.out.println("Invalid Input");
			}
		} while (true);

	}
}
