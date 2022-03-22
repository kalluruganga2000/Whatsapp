package com.Flipkart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Flipkart.controller.FlipkartController;
import com.Flipkart.controller.FlipkartControllerInterface;
import com.Flipkart.entity.FlipkartUser;

public class ControllerTest {
	
	FlipkartControllerInterface fc=null;
	@Before
	public void setUp() throws Exception {
		fc=new FlipkartController();
	}

	@After
	public void tearDown() throws Exception {
		fc=null;
	}

	@Test
	public void testSignUp() {
		int i=fc.signUp();
		assert i>0:"Test failed to signUP";
	}
	
	@Test
	public void testSignIn() {
		FlipkartUser user=fc.signIn();
		assert user!=null: "Test failed to signIn";
	}
	@Test
	public void testviewProfileController() {
		FlipkartUser user=fc.viewProfileController();
		assert user!=null:"Test failed to viewProfileController";
	}
	@Test
	public void testviewAllProfileController() {
		List<FlipkartUser> user=fc.viewAllProfileController();
		assert user.size()>0:"Test failed to viewProfileController";
	}
	@Test
	public void testdeleteProfileController() {
		int i=fc.deleteProfileController();
		assert i>0:"Test failed to deleteProfileController";
	}
	@Test
	public void testsearchProfileController() {
		FlipkartUser user=fc.searchProfileController();
		assert user!=null:"Test failed to searchProfileController";
	}
	@Test
	public void testeditProfileController() {
		int i=fc.editProfileController();
		assert i>0:"test failed to editProfileController";
	}
	@Test
	public void testsortByNameController() {
		List<FlipkartUser> user=fc.sortByNameController();
		assert  user!=null:"Test failed to sortNyNameController";
	}

}
