package fr.charbo.velov.integration;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;


@Entity
@Table(name="station")
public class StationEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8835507093395257914L;

	@EmbeddedId
	private StationKey stationKey;
	
	@Column(name="NAME")
	private String name;
	
	
	@Column(name="STATUT")
	private String statut;
	
	@Column(name="TOTALES")
	private int totales;
	
	@Column(name="DISPONIBLES")
	private int disponibles;
	
	@Column(name="OCCUPEES")
	private int occupees;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="JOUR")
	private int jour;
		
	@Column(name="MOIS")
	private int mois;
	
	@Column(name="HEURE")
	private int heure;
	
	@Column(name="MINUTE")
	private int minute;
	
	@Column(name="FULL")
	private int full;
	
	@Column(name="EMPTY")
	private int empty;

	@Column(name="NUMERO_JOUR")
	//Numéro du jour de la semaine (1 == dimanche)
	private int numeroJour;
	
	@Column(name="VELOV_IN")
	private int velovIn;
	
	@Column(name="VELOV_OUT")
	private int velovOut;
	
	@Column(name="TEMPS_VIDE")
	private long tempsVide;
	
	@Column(name="TEMPS_PLEINE")
	private long tempsPleine;
	
	@Column(name="INTERVALLE")
	private int intervalle;
	
	@Column(name="INTERVALLE15")
	private int intervalle15;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StationKey getStationKey() {
		return stationKey;
	}

	public void setStationKey(StationKey stationKey) {
		this.stationKey = stationKey;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getTotales() {
		return totales;
	}

	public void setTotales(int totales) {
		this.totales = totales;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public int getOccupees() {
		return occupees;
	}

	public void setOccupees(int occupees) {
		this.occupees = occupees;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getFull() {
		return full;
	}

	public void setFull(int full) {
		this.full = full;
	}
	
	public int getEmpty() {
		return empty;
	}

	public void setEmpty(int empty) {
		this.empty = empty;
	}

	public void setNumeroJour(int numeroJour) {
		this.numeroJour = numeroJour;
	}
	
	public int getNumeroJour() {
		return numeroJour;
	}
	
	
	public int getVelovIn() {
		return velovIn;
	}

	public void setVelovIn(int velovIn) {
		this.velovIn = velovIn;
	}

	public int getVelovOut() {
		return velovOut;
	}

	public void setVelovOut(int velovOut) {
		this.velovOut = velovOut;
	}

	public long getTempsVide() {
		return tempsVide;
	}

	public void setTempsVide(long tempsVide) {
		this.tempsVide = tempsVide;
	}

	public long getTempsPleine() {
		return tempsPleine;
	}

	public void setTempsPleine(long tempsPleine) {
		this.tempsPleine = tempsPleine;
	}

	public int getIntervalle() {
		return intervalle;
	}

	public void setIntervalle(int intervalle) {
		this.intervalle = intervalle;
	}

	public int getIntervalle15() {
		return intervalle15;
	}

	public void setIntervalle15(int intervalle15) {
		this.intervalle15 = intervalle15;
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
	    StationEntity other = (StationEntity) obj;
	    return stationKey.equals(other.stationKey);
	}

	@Override
	public String toString() {
		return "StationEntity [stationKey=" + stationKey + ", name=" + name
				+ ", disponibles=" + disponibles + ", occupees=" + occupees
				+ ", velovIn=" + velovIn + ", velovOut=" + velovOut + "]";
	}



	
	
}
