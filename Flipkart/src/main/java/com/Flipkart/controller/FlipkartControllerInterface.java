package com.Flipkart.controller;

import java.util.List;

import com.Flipkart.entity.FlipkartUser;

public interface FlipkartControllerInterface {

	int signUp();

	FlipkartUser signIn();

	FlipkartUser viewProfileController();

	List<FlipkartUser> viewAllProfileController();

	int  deleteProfileController();

	FlipkartUser searchProfileController();

	int editProfileController();

	List<FlipkartUser> sortByNameController();

}
