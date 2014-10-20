/**
 * 
 */
package org.air.care.validator;

import org.air.care.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author B.Pirasanth
 *
 */
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"Password.validation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm",
				"PasswordConfirm.validation");
		User user = (User) obj;
		if (!user.getPassword().equals(user.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", "passwordConfirmDiff.validation");
		}

	}

}
