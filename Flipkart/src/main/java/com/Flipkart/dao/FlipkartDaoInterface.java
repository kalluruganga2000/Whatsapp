package com.Flipkart.dao;

import java.util.List;

import com.Flipkart.entity.FlipkartUser;

public interface FlipkartDaoInterface {

	int signUp(FlipkartUser fu);

	FlipkartUser signIn(FlipkartUser fu);

	FlipkartUser viewProfileDao(FlipkartUser fu);

	List<FlipkartUser> viewAllProfileDao();

	int deleteProfileDao(FlipkartUser fu);

	FlipkartUser searchProfileDao(FlipkartUser fu);

	int editProfileDao(FlipkartUser fu, FlipkartUser fu1);

}
