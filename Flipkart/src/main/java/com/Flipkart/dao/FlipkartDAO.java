package com.Flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Flipkart.entity.FlipkartUser;

public class FlipkartDAO implements FlipkartDaoInterface {
	
	Connection con=null;
	FlipkartUser fu;
	public FlipkartDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","ganga");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int signUp(FlipkartUser fu) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			if(fu.getFirstname().equals("rahul")) {
				throw new UserDefinedException();
			}
			
			PreparedStatement ps=con.prepareStatement("insert into FlipkartUser values(?,?,?,?,?)");
			ps.setString(1,fu.getFirstname());
			ps.setString(2,fu.getLastname());
			ps.setString(3,fu.getEmail());
			ps.setString(4,fu.getPassword());
			ps.setString(5,fu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(UserDefinedException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FlipkartUser signIn(FlipkartUser fu) {
		FlipkartUser s1=null;
		try {
			PreparedStatement ps=con.prepareStatement("select *from FlipkartUser where email=?");
			ps.setString(1,fu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String email=res.getString(3);
				String password=res.getString(4);
				
				s1=new FlipkartUser();
				
				s1.setEmail(email);
				s1.setPassword(password);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;
	}

	public FlipkartUser viewProfileDao(FlipkartUser fu) {
		FlipkartUser s1=null;
		try {
			PreparedStatement ps=con.prepareStatement("select *from FlipkartUser where email=?");
			ps.setString(1,fu.getEmail());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String email=res.getString(3);
				String password=res.getString(4);
				String address=res.getString(5);
				
				s1=new FlipkartUser();
				
				s1.setFirstname(firstname);
				s1.setLastname(lastname);
				s1.setEmail(email);
				s1.setPassword(password);
				s1.setAddress(address);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return s1;
}
	
	@Override
	public List<FlipkartUser> viewAllProfileDao() {
		List<FlipkartUser> ll=new ArrayList<FlipkartUser>();
		try {
			PreparedStatement ps=con.prepareStatement("select *from FlipkartUser");
			
			
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String email=res.getString(3);
				String password=res.getString(4);
				String address=res.getString(5);
				
				FlipkartUser fu=new FlipkartUser();
				
				fu.setFirstname(firstname);
				fu.setLastname(lastname);
				fu.setEmail(email);
				fu.setPassword(password);
				fu.setAddress(address);
				
				ll.add(fu);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}
	@Override
	public int deleteProfileDao(FlipkartUser fu) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from FlipkartUser where email=?");
			ps.setString(1,fu.getEmail());
			i=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public FlipkartUser searchProfileDao(FlipkartUser fu) {
		FlipkartUser s1=null;
		try {
			PreparedStatement ps=con.prepareStatement("select *from FlipkartUser where Firstname=?");
			ps.setString(1,fu.getFirstname());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String firstname=res.getString(1);
				String lastname=res.getString(2);
				String email=res.getString(3);
				String password=res.getString(4);
				String address=res.getString(5);
				
				s1=new FlipkartUser();
				s1.setFirstname(firstname);
				s1.setLastname(lastname);
				s1.setEmail(email);
				s1.setPassword(password);
				s1.setAddress(address);
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return s1;
	}
	@Override
	public int editProfileDao(FlipkartUser fu, FlipkartUser fu1) {
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("update FlipkartUser set firstname=?,lastname=?,password=?,address=?  where email=?");
			ps.setString(1, fu1.getFirstname());
			ps.setString(2,fu1.getLastname());
			ps.setString(3, fu1.getPassword());
			ps.setString(4, fu1.getAddress());
			ps.setString(5,fu.getEmail());
			
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}


