package org.air.care.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
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
@Transactional
public class UserServiceImplTest {

	private static final Log logger = LogFactory
			.getLog(UserServiceImplTest.class);

	@Autowired
	UserService userService;

	@Test
	public void save() throws ExceptionResourceAlredyExist {
		logger.info("====TEST SAVE USER====");
		User user = new User();
		user.setFirstName("Dinuka");
		user.setLastName("Malalanayake");
		user.setUsername("dinuka");
		user.setPassword("dinuka");
		user.setSequrityQuestion("What is your pet name?");
		user.setAnswer("jimbo");
		user = userService.saveUser(user, Locale.getDefault());

		assertNotNull(user.getId());
		System.out.println("User ID" + user.getId());
	}

	@Test
	public void getByUserName() throws ExceptionResourceAlredyExist {
		logger.info("====TEST GET BY USER NAME====");
		User user = new User();
		user.setFirstName("Dinuka");
		user.setLastName("Malalanayake");
		user.setUsername("dinuka");
		user.setPassword("dinuka");
		user.setSequrityQuestion("What is your pet name?");
		user.setAnswer("jimbo");
		user = userService.saveUser(user, Locale.getDefault());

		assertNotNull(userService.getUserByID(user.getId()));
		User userfromDB = userService.getUserByUserName("dinuka");
		assertNotNull(userfromDB);
		assertEquals(user.getFirstName(), userfromDB.getFirstName());
		assertEquals(user.getLastName(), userfromDB.getLastName());
		assertEquals(user.getUsername(), userfromDB.getUsername());
		assertEquals(user.getPassword(), userfromDB.getPassword());
		assertEquals(user.getSequrityQuestion(),
				userfromDB.getSequrityQuestion());
		assertEquals(user.getAnswer(), userfromDB.getAnswer());
		System.out.println("User ID" + user.getId());
	}

}
