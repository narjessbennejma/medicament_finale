package com.example.medicament.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idforme;
	private String nomforme;
	private String descriptionforme;
	@JsonIgnore
	@OneToMany(mappedBy = "forme")
	private List<Medicament> medicaments;
	
	
	
	
}
