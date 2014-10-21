package org.air.care.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity which is going to store the Path details
 * 
 * @author malalanayake
 *
 */
@Entity
public class Path implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ManyToOne(fetch = FetchType.EAGER)
	private Airport airportOut;
	
	@Valid
	@ManyToOne(fetch = FetchType.EAGER)
	private Airport airportIn;
	
	public Path() {
		this.airportOut = new Airport();
		this.airportIn = new Airport();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Airport getAirportOut() {
		return airportOut;
	}

	public void setAirportOut(Airport airportOut) {
		this.airportOut = airportOut;
	}

	public Airport getAirportIn() {
		return airportIn;
	}

	public void setAirportIn(Airport airportIn) {
		this.airportIn = airportIn;
	}

}
