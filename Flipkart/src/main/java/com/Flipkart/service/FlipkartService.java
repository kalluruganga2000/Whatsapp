package com.Flipkart.service;

import java.util.List;

import com.Flipkart.dao.FlipkartDaoInterface;
import com.Flipkart.entity.FlipkartUser;
import com.Flipkart.utility.DaoFactory;

public class FlipkartService implements FlipkartServiceInterface {
	FlipkartDaoInterface fd=DaoFactory.daoObject();
	
	public int signUp(FlipkartUser fu) {
	
		int i=fd.signUp(fu);
		return i;
	}

	public FlipkartUser signIn(FlipkartUser fu) {
		
		FlipkartUser s1=fd.signIn(fu);
		return s1;
		
		
	}

	public FlipkartUser viewProfileService(FlipkartUser fu) {
		
		FlipkartUser s1=fd.viewProfileDao(fu);
		return s1;
		
	}

	@Override
	public List<FlipkartUser> viewAllProfileService() {
		List<FlipkartUser> s1=fd.viewAllProfileDao();
		return s1;
		
	}

	@Override
	public int deleteProfileService(FlipkartUser fu) {
		int i=fd.deleteProfileDao(fu);
		return i;
	}

	@Override
	public FlipkartUser searchProfileService(FlipkartUser fu) {
		FlipkartUser s1=fd.searchProfileDao(fu);
		return s1;

		
	}

	@Override
	public int editProfileService(FlipkartUser fu, FlipkartUser fu1) {
		int i=fd.editProfileDao(fu,fu1);
		return i;
	}

}
