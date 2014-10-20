/**
 * 
 */
package org.air.care.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity which is going to store the passenger details
 * 
 * @author Amila
 *
 */
@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "[A-Za-z]+", message = "{Pattern.Passenger.firstName.validation}")
	private String firstName;
	@Pattern(regexp = "[A-Za-z]+", message = "{Pattern.Passenger.lastName.validation}")
	private String lastName;
	
	@Pattern(regexp = "[A-Za-z0-9]+", message = "{Pattern.Passenger.passportNumber.validation}")
	private String passportNumber;
	
	@NotEmpty(message="{NotEmpty}")
	@Email(message="{Email}")
	private String emailAddress;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
