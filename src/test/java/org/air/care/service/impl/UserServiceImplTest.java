package org.air.care.service.impl;

import static org.junit.Assert.*;

import org.air.care.model.User;
import org.air.care.service.UserService;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test user service operations
 * 
 * @author malalanayake
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
public class UserServiceImplTest {

	@Autowired
	UserService userService;

	@Test
	public void test() {
		User user = new User();
		user.setFirstName("Dinuka");
		user.setLastName("Malalanayake");
		user.setUsername("dinuka");
		user.setPassword("dinuka");
		user.setSequrityQuestion("What is your pet name?");
		user.setAnswer("jimbo");
		user = userService.saveUser(user);

		assertNotNull(user.getId());
		System.out.println("User ID" + user.getId());
	}

}
