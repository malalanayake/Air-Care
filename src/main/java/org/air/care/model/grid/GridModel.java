/**
 * 
 */
package org.air.care.model.grid;

import java.util.Date;

import org.air.care.model.Path;

/**
 * @author B.Pirasanth
 *
 */
public class GridModel {
	private Path path;
	private String flightNo;
	private String airlineName;
	private Date depatureTime;

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
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

}
