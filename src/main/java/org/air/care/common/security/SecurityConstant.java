package org.air.care.common.security;

/**
 * Interface which is provide the security constants
 * 
 * @author malalanayake
 *
 */
public interface SecurityConstant {

	// Authorization role names
	public final String ROLE_CLIENT = "ROLE_CLIENT";
	public final String ROLE_ADMIN = "ROLE_ADMIN";

	// Security Questions
	public final String[] SECURITY_QUESTIONS = {
			"What is the first name of the person you first kissed?",
			"What is the last name of the teacher who gave you your first failing grade?",
			"What is the name of the place your wedding reception was held?",
			"What is the name of the first beach you visited?",
			"In what city or town did you meet your spouse/partner?",
			"What was the make and model of your first car?",
			"What was your maternal grandfather's first name?",
			"In what city or town does your nearest sibling live?" };
}
