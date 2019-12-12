package com.ensat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "avion")
public class Avion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
	private Integer ref_avion;
    private Integer nbr_place;
    private  String agence;
    
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

    
	public Integer getRef_avion() {
		return ref_avion;
	}
	public void setRef_avion(Integer ref_avion) {
		this.ref_avion = ref_avion;
	}
	public Integer getNbr_place() {
		return nbr_place;
	}
	public void setNbr_place(Integer nbr_place) {
		this.nbr_place = nbr_place;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
    
}
