package org.air.care.service.impl;

import java.util.ArrayList;

import org.air.care.common.security.SecurityConstant;
import org.air.care.model.User;
import org.air.care.repository.UserRepository;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service implementation
 * 
 * @author malalanayake
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUserName(String userName) {
		return userRepository.findOneByUsername(userName);
	}

	@Override
	public User saveUser(User user) {
		ArrayList<String> roles = new ArrayList<String>();
		roles.add(SecurityConstant.ROLE_CLIENT);
		user.setRoles(roles);
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public void updateUser(User user) {

	}

	@Override
	public User getUserByID(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public String[] getSecurityQuestions() {
		return SecurityConstant.SECURITY_QUESTIONS;
	}

}
