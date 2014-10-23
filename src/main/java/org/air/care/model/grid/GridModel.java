/**
 * 
 */
package org.air.care.model.grid;

import java.util.Date;

/**
 * @author B.Pirasanth
 *
 */
public class GridModel {
	private String path;
	private String latLngs;
	private String flightNo;
	private String airlineName;
	private Date depatureTime;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Date getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(Date depatureTime) {
		this.depatureTime = depatureTime;
	}

	public String getLatLngs() {
		return latLngs;
	}

	public void setLatLngs(String latLngs) {
		this.latLngs = latLngs;
	}
	
	

}
