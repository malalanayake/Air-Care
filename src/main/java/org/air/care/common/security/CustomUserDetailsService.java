package org.air.care.common.security;

import java.util.ArrayList;
import java.util.Collection;

import org.air.care.model.User;
import org.air.care.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User details service which is going to plug in to the spring security
 * 
 * @author malalanayake
 *
 */
@Service("customUserDetailsService")
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String authentication)
			throws UsernameNotFoundException {
		CustomUserDetails customUserData = new CustomUserDetails();
		User user = userRepository.findOneByUsername(authentication);
		
		if (user != null) {
			customUserData.setAuthentication(true);
			customUserData.setId(user.getId().toString());
			customUserData.setUserName(user.getUsername());
			customUserData.setPassword(user.getPassword());
			Collection<CustomRole> roles = new ArrayList<CustomRole>();
			for (String role : user.getRoles()) {
				CustomRole customRole = new CustomRole();
				customRole.setAuthority(role);
				roles.add(customRole);
			}
			customUserData.setAuthorities(roles);
			return customUserData;
		} else {
			return null;
		}
	}

}
