package fr.charbo.velov.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
//	
//	{
//		  "number": 123,
//		  "contract_name" : "Paris",
//		  "name": "nom station",
//		  "address": "adresse indicative",
//		  "position": {
//		    "lat": 48.862993,
//		    "lng": 2.344294
//		  },
//		  "banking": true,
//		  "bonus": false,
//		  "status": "OPEN",
//		  "bike_stands": 20,
//		  "available_bike_stands": 15, le nombre de points d'attache disponibles pour y ranger un vélo
//		  "available_bikes": 5,
//		  "last_update": <timestamp>
//		}
	
	@JsonProperty("number")
	private String idStation;

	@JsonProperty("status")
	private String status;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("bike_stands")
	private Integer bikeStands;
	
	@JsonProperty("available_bike_stands")
	private Integer disponibles;
	
	@JsonProperty("available_bikes")
	private Integer occupees;
	
	@JsonProperty("last_update")
	private Long updateTime;
	
	

	public String getIdStation() {
		return idStation;
	}

	public void setIdStation(String idStation) {
		this.idStation = idStation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBikeStands() {
		return bikeStands;
	}

	public void setBikeStands(Integer bikeStands) {
		this.bikeStands = bikeStands;
	}

	public Integer getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(Integer disponibles) {
		this.disponibles = disponibles;
	}

	public Integer getOccupees() {
		return occupees;
	}

	public void setOccupees(Integer occupees) {
		this.occupees = occupees;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

}
