package com.ensat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Product entity.
 */
@Entity
public class Bagage {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

  //@Poid
    private Double poid;
    private Integer nombre;
    private BigDecimal price;
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPoid() {
		return poid;
	}
	public void setPoid(Double poid) {
		this.poid = poid;
	}
	public Integer getNombre() {
		return nombre;
	}
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

	
	
}
