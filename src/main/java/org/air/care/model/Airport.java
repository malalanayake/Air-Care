package org.air.care.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity which is going to store the Aireport details
 * 
 * @author malalanayake
 *
 */
@Entity
public class Airport implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	private Double latitude;
	private Double longitude;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airportIn")
	private List<Path> listOfOutPaths;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "airportOut")
	private List<Path> listOfInPaths;

	public Airport() {
		listOfInPaths = new ArrayList<Path>();
		listOfOutPaths = new ArrayList<Path>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Path> getListOfOutPaths() {
		return listOfOutPaths;
	}

	public void setOutPath(Path start) {
		listOfOutPaths.add(start);
	}

	public void setInPath(Path end) {
		listOfInPaths.add(end);
	}

	public void setListOfOutPaths(List<Path> listOfOutPaths) {
		this.listOfOutPaths = listOfOutPaths;
	}

	public List<Path> getListOfInPaths() {
		return listOfInPaths;
	}

	public void setListOfInPaths(List<Path> listOfInPaths) {
		this.listOfInPaths = listOfInPaths;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
