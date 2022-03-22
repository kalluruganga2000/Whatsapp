package com.Flipkart.utility;

import com.Flipkart.service.FlipkartService;
import com.Flipkart.service.FlipkartServiceInterface;

public class ServiceFactory {

	public static FlipkartServiceInterface serviceObject() {
		// TODO Auto-generated method stub
		return new FlipkartService();
	}

	

}
