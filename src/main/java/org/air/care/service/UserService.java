package org.air.care.service;

import java.util.Locale;

import org.air.care.common.exception.ExceptionResourceAlredyExist;
import org.air.care.model.User;

/**
 * User Service interface which is provide the user operation to the contoller
 * 
 * @author malalanayake
 *
 */
public interface UserService {
	public User getUserByID(Long id);

	public User getUserByUserName(String userName);

	public User saveUser(User user, Locale locale) throws ExceptionResourceAlredyExist;

	public void deleteUser(User user);

	public void updateUser(User user);

	public String[] getSecurityQuestions();
}
