package com.ensat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enregistrement {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	 private String idvol;
	 private int numcarte ;
	 private String etat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdvol() {
		return idvol;
	}
	public void setIdvol(String idvol) {
		this.idvol = idvol;
	}
	public int getNumcarte() {
		return numcarte;
	}
	public void setNumcarte(int numcarte) {
		this.numcarte = numcarte;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	 
	 
	    
	
	
	

}
