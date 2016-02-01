package fr.charbo.velov.integration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class StationKey implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6120893453815228713L;

	@Column(name="ID")
	private long id;
	
	@Column(name="ID_STATION")
	private String idStation;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getIdStation() {
		return idStation;
	}

	public void setIdStation(String idStation) {
		this.idStation = idStation;
	}
	
	@Override
	public String toString() {
		return id + " " + idStation;
	}

	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    StationKey other = (StationKey) obj;
	    return new EqualsBuilder().append(id, other.id)
	                              .append(idStation, other.idStation)
	                              .isEquals();
	}
	
	

}
