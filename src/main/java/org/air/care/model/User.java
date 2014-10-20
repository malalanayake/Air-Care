package org.air.care.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.air.care.validator.UserName;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity which is going to store the User details
 * 
 * @author malalanayake
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "USERNAME")
	@NotEmpty(message = "{NotEmpty}")
	@UserName
	private String username;
	private String password;
	
	@Transient
	private String passwordConfirm;
	private ArrayList<String> roles;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Passenger> passengers;

	@Pattern(regexp = "[A-Za-z]+", message = "{Pattern.User.firstName.validation}")
	private String firstName;

	@Pattern(regexp = "[A-Za-z]+", message = "{Pattern.User.lastName.validation}")
	private String lastName;
	private String sequrityQuestion;

	@NotEmpty(message = "{NotEmpty}")
	private String answer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<String> roles) {
		this.roles = roles;
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

	public String getSequrityQuestion() {
		return sequrityQuestion;
	}

	public void setSequrityQuestion(String sequrityQuestion) {
		this.sequrityQuestion = sequrityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	

}
