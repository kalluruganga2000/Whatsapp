package com.Flipkart.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.Flipkart.entity.FlipkartUser;
import com.Flipkart.service.FlipkartServiceInterface;
import com.Flipkart.utility.ServiceFactory;
import com.Flipkart.utility.sortByName;

public class FlipkartController implements FlipkartControllerInterface {
	FlipkartServiceInterface fs=null;
	public FlipkartController(){
	  fs=ServiceFactory.serviceObject();
	}
	Logger log=Logger.getLogger("FlipkartController");
	
	public int signUp() {
		Scanner sc=new Scanner(System.in);
		
		log.info("enter Firstname");
		String firstname=sc.next();
		
		log.info("enter lastname");
		String lastname=sc.next();
		
		log.info("enter email");
		String email=sc.next();
		
		log.info("enter password");                                                                                                  
		String password=sc.next();
		
		log.info("enter Address");
		String address=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		
		fu.setFirstname(firstname);
		fu.setLastname(lastname);
		fu.setEmail(email);
		fu.setPassword(password);
		fu.setAddress(address);
		
		
		int i=fs.signUp(fu);
		
		if(i>0) {
			System.out.println("Profile created Successfully");
		}
		else {
			System.out.println("profile not created");
		}
		return i;
		
	}

	public FlipkartUser signIn() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		
		fu.setEmail(email);
		fu.setPassword(password);
		
		FlipkartUser s1=fs.signIn(fu);
		return s1;
		
	}

	public FlipkartUser viewProfileController() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email");
		String email=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		fu.setEmail(email);
		
		FlipkartUser s1=fs.viewProfileService(fu);
		
		if(s1!=null) {
			System.out.println("Firstname:"+s1.getFirstname());
			System.out.println("lastname :"+s1.getLastname());
			System.out.println("email    :"+s1.getEmail());
			System.out.println("password :"+s1.getPassword());
			System.out.println("address  :"+s1.getAddress());
		}
		else {
			System.out.println("profile not found");
		}
		return s1;
	}

	public List<FlipkartUser> viewAllProfileController() {
		List<FlipkartUser> ll=fs.viewAllProfileService();
		ll.forEach(s2->{
			System.out.println("************************************");
			System.out.println(s2.getFirstname());
			System.out.println(s2.getLastname());
			System.out.println(s2.getEmail());
			System.out.println(s2.getPassword());
			System.out.println(s2.getAddress());
		});
		return ll;
		
	}

	@Override
	public int deleteProfileController() {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter email");
		String email=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		fu.setEmail(email);
		
		int i=fs.deleteProfileService(fu);
		
		if(i>0) {
			System.out.println("profile deleted");
		}
		else {
			System.out.println("profile not deleted");
		}
		return i;
		
	}

	@Override
	public FlipkartUser searchProfileController() {
		System.out.println("SEARCHING PROFILES");
		System.out.println("enter firstname to search profile:  ");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		fu.setFirstname(name);
		
		FlipkartUser s1=fs.searchProfileService(fu);
		
		if(s1!=null) {
			System.out.println("Firstname  :"+s1.getFirstname());
			System.out.println("Lastname   :"+s1.getLastname());
			System.out.println("Email      :"+s1.getEmail());
			System.out.println("password   :"+s1.getPassword());
			System.out.println("Address    :"+s1.getAddress());
		}
		else {
			System.out.println("no profile found with the given firstname");
		}
		return s1;
	}

	@Override
	public int editProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Edit Profile");
		System.out.println("enter the email whose profile you want to edit:");
		String email=sc.next();
		
		FlipkartUser fu=new FlipkartUser();
		fu.setEmail(email);
		
		System.out.println("edit Firstname");
		String firstname=sc.next();
		
		System.out.println("edit lastname");
		String lastname=sc.next();
		
		System.out.println("edit password");
		String password=sc.next();
		
		System.out.println("edit Address");
		String address=sc.next();
		
		FlipkartUser fu1=new FlipkartUser();
		fu1.setFirstname(firstname);
		fu1.setLastname(lastname);
		fu1.setPassword(password);
		fu1.setAddress(address);
		
		int i=fs.editProfileService(fu,fu1);
		
		if(i>0) {
			System.out.println("profile edited");
		}
		else {
			System.out.println("coul not edit ur profile");
		}
		return i;
	}

	@Override
	public List<FlipkartUser> sortByNameController() {
		List<FlipkartUser> ll=fs.viewAllProfileService();
		System.out.println("*******Before Sorting**********");
		ll.forEach(s2->{
			System.out.println("************************************");
			System.out.println(s2.getFirstname());
			System.out.println(s2.getLastname());
			System.out.println(s2.getEmail());
			System.out.println(s2.getPassword());
			System.out.println(s2.getAddress());
			}); 
		Collections.sort(ll, new sortByName());
		System.out.println("*******After Sorting********");
		ll.forEach(s2->{
			System.out.println("************************************");
			System.out.println(s2.getFirstname());
			System.out.println(s2.getLastname());
			System.out.println(s2.getEmail());
			System.out.println(s2.getPassword());
			System.out.println(s2.getAddress());
		});
		return ll;
		
	}
		
}


