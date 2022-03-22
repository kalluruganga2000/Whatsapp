package com.Flipkart.service;

import java.util.List;

import com.Flipkart.entity.FlipkartUser;

public interface FlipkartServiceInterface {

	int signUp(FlipkartUser fu);

	FlipkartUser signIn(FlipkartUser fu);

	FlipkartUser viewProfileService(FlipkartUser fu);

	List<FlipkartUser> viewAllProfileService();

	int deleteProfileService(FlipkartUser fu);

	FlipkartUser searchProfileService(FlipkartUser fu);

	int editProfileService(FlipkartUser fu, FlipkartUser fu1);

}
