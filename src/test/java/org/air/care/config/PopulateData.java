package org.air.care.config;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.common.security.SecurityConstant;
import org.air.care.model.Airport;
import org.air.care.model.Path;
import org.air.care.model.User;
import org.air.care.service.AirportService;
import org.air.care.service.PathService;
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

	@Autowired
	AirportService airportService;

	@Autowired
	PathService pathService;

	@Test
	@Rollback(false)
	public void populateUsers() throws ExceptionResourceAlredyExist {
		// Populate the Admin
		User user = new User();
		user.setFirstName("Admin");
		user.setLastName("Admin");
		user.setUsername("admin");
		user.setPassword("admin");
		user.setSequrityQuestion("What is your pet name?");
		user.setAnswer("jimbo");
		ArrayList<String> userRoles = new ArrayList<String>();
		userRoles.add(SecurityConstant.ROLE_ADMIN);
		user.setRoles(userRoles);
		user = userService.saveUser(user, Locale.getDefault());

		// Populate the client
		User client = new User();
		client.setFirstName("Client");
		client.setLastName("Client");
		client.setUsername("client");
		client.setPassword("client");
		client.setSequrityQuestion("What is your pet name?");
		client.setAnswer("jimbo");
		ArrayList<String> clientRoles = new ArrayList<String>();
		clientRoles.add(SecurityConstant.ROLE_CLIENT);
		client.setRoles(clientRoles);
		client = userService.saveUser(client, Locale.getDefault());

		assertNotNull(client.getId());
		System.out.println("Client ID" + client.getId());
	}

	@Test
	@Rollback(false)
	public void populateAirportsAndPaths() {
		// Add airport1
		Airport airport1 = new Airport();
		airport1.setName("Chicago");
		airport1.setLocation("1-99 Upper Level T2 St, Chicago O'Hare International Airport, Chicago, IL 60666, USA");
		airport1.setLatitude(41.974162);
		airport1.setLongitude(-87.90732100000002);
		try {
			airport1 = airportService.save(airport1, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport1.getId());

		// Add airport2
		Airport airport2 = new Airport();
		airport2.setName("Desmoin");
		airport2.setLocation("3101 Army Post Road, Des Moines International Airport (DSM), Des Moines, IA 50321, USA");
		airport2.setLatitude(41.534133);
		airport2.setLongitude(-93.658796);
		try {
			airport2 = airportService.save(airport2, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport2.getId());

		// Add airport3
		Airport airport3 = new Airport();
		airport3.setName("Ames");
		airport3.setLocation("Ames Muni, Ames Municipal Airport (AMW), Ames, IA 50010, USA");
		airport3.setLatitude(41.991943);
		airport3.setLongitude(-93.62194799999997);
		try {
			airport3 = airportService.save(airport3, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport3.getId());

		// Add airport4
		Airport airport4 = new Airport();
		airport4.setName("Atlanta");
		airport4.setLocation("Concourse E, Hartsfield-Jackson Atlanta International Airport, Georgia 30337, USA");
		airport4.setLatitude(33.640728);
		airport4.setLongitude(-84.42770000000002);
		try {
			airport4 = airportService.save(airport4, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport4.getId());

		// Add airport5
		Airport airport5 = new Airport();
		airport5.setName("LaGuardia");
		airport5.setLocation("Central Terminal Drive, LaGuardia Airport (LGA), East Elmhurst, NY 11371, USA");
		airport5.setLatitude(40.776927);
		airport5.setLongitude(-73.873966);
		try {
			airport5 = airportService.save(airport5, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport5.getId());

		// Add airport6
		Airport airport6 = new Airport();
		airport6.setName("San Francisco");
		airport6.setLocation("Airport Access Road, San Francisco International Airport (SFO), San Francisco, CA 94128, USA");
		airport6.setLatitude(37.621313);
		airport6.setLongitude(-122.37895500000002);
		try {
			airport6 = airportService.save(airport6, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport6.getId());

		// Add airport7
		Airport airport7 = new Airport();
		airport7.setName("Miami International");
		airport7.setLocation("5815 Northwest 18th Street, Miami International Airport (MIA), Miami, FL 33126, USA");
		airport7.setLatitude(25.795865);
		airport7.setLongitude(-80.28704600000003);
		try {
			airport7 = airportService.save(airport7, Locale.getDefault());
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
		assertNotNull(airport7.getId());

		// airport1 -> airport2 ==> Chicargo to Desmoin
		try {
			pathService.save(airport1, airport2);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport2 -> airport3 ==> Desmoin to Ames
		try {
			pathService.save(airport2, airport3);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport3 -> airport2 ==> Ames to Desmoin
		try {
			pathService.save(airport3, airport2);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport1 -> airport6 ==> Chicargo to San Francisco
		try {
			pathService.save(airport1, airport6);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport6 -> airport1 ==> San Francisco to Chicargo
		try {
			pathService.save(airport6, airport1);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport1 -> airport7 ==> Chicargo to Miami International
		try {
			pathService.save(airport1, airport7);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport7 -> airport1 ==> Miami International to Chicargo
		try {
			pathService.save(airport7, airport1);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}

		// airport7 -> airport6 ==> Miami International to San Francisco
		try {
			pathService.save(airport7, airport6);
		} catch (ExceptionResourceAlredyExist e) {
			assertFalse(true);
		}
	}

}
