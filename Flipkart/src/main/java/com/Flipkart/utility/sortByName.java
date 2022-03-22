package com.Flipkart.utility;

import java.util.Comparator;

import com.Flipkart.entity.FlipkartUser;

public class sortByName implements Comparator<FlipkartUser> {

	public int compare(FlipkartUser u1, FlipkartUser u2) {
		return u1.getFirstname().compareTo(u2.getFirstname());
	}

}
