package com.example.medicament.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.medicament.entities.Forme;



public interface FormeServices {

	
	List<Forme> getAllFormes();
	Forme saveForme(Forme forme);
	Page<Forme> getAllFormesParPage(int i, int j);
	void deleteFormeById(Long id);
	Forme getFormes(Long id);
	Forme updateFormes(Forme f);
	List<Forme> findAll();
}
