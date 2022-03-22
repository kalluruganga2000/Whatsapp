package com.Flipkart.view;

import java.util.Scanner;
//import java.util.logging.Logger;

import com.Flipkart.controller.FlipkartControllerInterface;
import com.Flipkart.entity.FlipkartUser;
import com.Flipkart.utility.ControllerFactory;

public class FlipkartView {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		//Logger log=Logger.getLogger("FlipkartView");
		
		FlipkartUser s1 = null;
		
		String s="y";
		
		while(s.equals("y")) {
		
		System.out.println("press 1 to signUp");
		System.out.println("press 2 to signIn");
		System.out.println("enter your choice");
		int ch=sc.nextInt();
		
		FlipkartControllerInterface fc=ControllerFactory.controllerObject();
		
		switch(ch) {
			case 1:fc.signUp();
				break;
			case 2:s1=fc.signIn();
					if(s1!=null) {
						while(s.equals("y")) {
							System.out.println("press 1 to view profile");
							System.out.println("press 2 to viewall  profiles");
							System.out.println("press 3 to delete profile");
							System.out.println("press 4 to search profile");
							System.out.println("press 5 to edit profile");
							System.out.println("press 6 to sort profile");
							System.out.println("enter your choice:");
							 ch=sc.nextInt();
							 
							 switch(ch) {
							 case 1:fc.viewProfileController();
							 	break;
							 case 2:fc.viewAllProfileController();
							 	break;
							 case 3:fc.deleteProfileController();
							 	break;
							 case 4:fc.searchProfileController();
							 	break;
							 case 5:fc.editProfileController();
							 	break;
							 case 6:fc.sortByNameController();
								 break;
							 }
						
							 System.out.println("enter press y/n to continue");
							 s=sc.next();
						}
						
					}
		
					else {
						System.out.println("Oops you are not registered.please press 1 to signUp");
					}
					break;
		}
		System.out.println("enter y/n to continue ");
		s=sc.next();
		

	}

}
}
