package com.example.medicament.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;




@Entity
public class Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicament;
	@NonNull
	@Size (min = 4,max = 25)
	private String nomMedicament;
	@NonNull
	@Min(value = 10)
	 @Max(value = 10000)

	private Double prixMedicament;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	private Date dateCreation; 
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	

	private Date dateexpiration;
	
	@ManyToOne
	private Forme forme;


	

	/*public Medicament(String nomMedicament, Double prixMedicament, Date dateCreation, Date dateexpiration) {
		super();
		this.nomMedicament = nomMedicament;
		this.prixMedicament = prixMedicament;
		this.dateCreation = dateCreation;
		this.dateexpiration = dateexpiration;
	}
	*/

	public Medicament() {
		super();
		
	}


	public Long getIdMedicament() {
		return idMedicament;
	}


	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}


	public String getNomMedicament() {
		return nomMedicament;
	}


	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}


	public Double getPrixMedicament() {
		return prixMedicament;
	}


	public void setPrixMedicament(Double prixMedicament) {
		this.prixMedicament = prixMedicament;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Date getDateexpiration() {
		return dateexpiration;
	}


	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}


	

	public Medicament( String nomMedicament, Double prixMedicament, Date dateCreation,
			Date dateexpiration, Forme forme) {
		super();
		
		this.nomMedicament = nomMedicament;
		this.prixMedicament = prixMedicament;
		this.dateCreation = dateCreation;
		this.dateexpiration = dateexpiration;
		this.forme = forme;
	}


	public Forme getForme() {
		return forme;
	}


	public void setForme(Forme forme) {
		this.forme = forme;
	}


	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", prixMedicament="
				+ prixMedicament + ", dateCreation=" + dateCreation + ", dateexpiration=" + dateexpiration
				+ ", forme=" + forme + "]";
	}
	
	

	
	
}
