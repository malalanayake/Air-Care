/**
 * 
 */
package org.air.care.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.air.care.validator.UserName;
import org.air.care.model.User;
import org.air.care.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author B.Pirasanth
 *
 */
public class UserNameValidator implements ConstraintValidator<UserName, String> {

	@Autowired
	private UserService userService;

	public void initialize(UserName constraintAnnotation) {
		// intentionally left blank; this is the place to initialize the
		// constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		User user;
		user = userService.getUserByUserName(value);

		if (user != null) {
			return false;
		}

		return true;
	}

}
