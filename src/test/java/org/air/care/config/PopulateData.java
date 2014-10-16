package org.air.care.config;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.air.care.common.security.RoleName;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test for populate the initial data
 * 
 * @author malalanayake
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/servlet-context-test.xml",
		"classpath:/root-context-test.xml" })
@Transactional
public class PopulateData {
	@Autowired
	UserService userService;

	@Test
	@Rollback(false)
	public void populateUsers() {
		// Populate the Admin
		User user = new User();
		user.setFirstName("Admin");
		user.setLastName("Admin");
		user.setUsername("admin");
		user.setPassword("admin");
		user.setSequrityQuestion("What is your pet name?");
		user.setAnswer("jimbo");
		ArrayList<String> userRoles = new ArrayList<String>();
		userRoles.add(RoleName.ROLE_ADMIN);
		user.setRoles(userRoles);
		user = userService.saveUser(user);

		// Populate the client
		User client = new User();
		client.setFirstName("Client");
		client.setLastName("Client");
		client.setUsername("client");
		client.setPassword("client");
		client.setSequrityQuestion("What is your pet name?");
		client.setAnswer("jimbo");
		ArrayList<String> clientRoles = new ArrayList<String>();
		clientRoles.add(RoleName.ROLE_CLIENT);
		client.setRoles(clientRoles);
		client = userService.saveUser(client);

		assertNotNull(client.getId());
		System.out.println("Client ID" + client.getId());
	}

}
