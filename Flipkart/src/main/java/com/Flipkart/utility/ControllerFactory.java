package com.Flipkart.utility;

import com.Flipkart.controller.FlipkartController;
import com.Flipkart.controller.FlipkartControllerInterface;

public class ControllerFactory {

	public static FlipkartControllerInterface controllerObject() {
		// TODO Auto-generated method stub
		return new FlipkartController();
	}

}
