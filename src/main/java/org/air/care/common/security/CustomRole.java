package org.air.care.common.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Custom role class for manage the authorities
 * 
 * @author malalanayake
 *
 */
public class CustomRole implements GrantedAuthority {
	String role = null;

	@Override
	public String getAuthority() {
		return role;
	}

	public void setAuthority(String role) {
		this.role = role;
	}

}
