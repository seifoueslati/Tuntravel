package com.ensat.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vol")
public class Vol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private int ref_avion;
	private String direction,aeroport_esc;
	private Date heure_dep ,heure_arriv,heure_esc;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getRef_avion() {
		return ref_avion;
	}
	public void setRef_avion(int ref_avion) {
		this.ref_avion = ref_avion;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getAeroport_esc() {
		return aeroport_esc;
	}
	public void setAeroport_esc(String aeroport_esc) {
		this.aeroport_esc = aeroport_esc;
	}
	public Date getHeure_dep() {
		return heure_dep;
	}
	public void setHeure_dep(Date heure_dep) {
		this.heure_dep = heure_dep;
	}
	public Date getHeure_arriv() {
		return heure_arriv;
	}
	public void setHeure_arriv(Date heure_arriv) {
		this.heure_arriv = heure_arriv;
	}
	public Date getHeure_esc() {
		return heure_esc;
	}
	public void setHeure_esc(Date heure_esc) {
		this.heure_esc = heure_esc;
	}
	
}
