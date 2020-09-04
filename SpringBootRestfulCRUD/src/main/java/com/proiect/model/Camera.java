  package com.proiect.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "camere")
 public class Camera implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Transient 
	private Integer cladire_id;
	
	private String nume;
	
	private int suprafata;
	
	@JsonBackReference
	@ManyToOne
	private Cladire cladire;
	
	@OneToMany(mappedBy="camera1" , cascade = CascadeType.REMOVE)
	private Set<Usa> usi;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCladire_id() {
		return cladire_id;
	}

	public void setCladire_id(Integer cladire_id) {
		this.cladire_id = cladire_id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getSuprafata() {
		return suprafata;
	}

	public void setSuprafata(int suprafata) {
		this.suprafata = suprafata;
	}

	public Cladire getCladire() {
		return cladire;
	}

	public void setCladire(Cladire cladire) {
		this.cladire = cladire;
	}


	
	
	
	
	


	
	
	


	
}
