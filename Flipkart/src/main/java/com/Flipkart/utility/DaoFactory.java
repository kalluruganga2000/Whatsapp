package com.Flipkart.utility;

import com.Flipkart.dao.FlipkartDAO;
import com.Flipkart.dao.FlipkartDaoInterface;

public class DaoFactory {

	public static FlipkartDaoInterface daoObject() {
		// TODO Auto-generated method stub
		return new FlipkartDAO();
	}

}
