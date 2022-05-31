package com.example.medicament.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.medicament.entities.Forme;
import com.example.medicament.entities.Medicament;
import com.example.medicament.repos.MedicamentRepository;

@Service
public class MedicamentServiceImpl implements MedicamentService {

	@Autowired
	MedicamentRepository medicamenRepository;	
	
	@Override
	public Medicament saveMedicament(Medicament m) {
		
		return medicamenRepository.save(m);
	}

	@Override
	public Medicament updateMedicament(Medicament m) {
		
		return medicamenRepository.save(m);
	}

	@Override
	public void deleteMedicament(Medicament m) {
		medicamenRepository.delete(m);
		
	}

	@Override
	public void deleteMedicamentById(Long id) {
		
		medicamenRepository.deleteById(id);
	}

	@Override
	public Medicament getMedicament(Long id) {
		
		return medicamenRepository.findById(id).get();
	}

	@Override
	public List<Medicament> getAllMedicaments() {
		
		return medicamenRepository.findAll();
	}

	@Override
	public Page<Medicament> getAllMedicamentsParPage(int page, int size) {
		
		return medicamenRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Medicament> findByNomMedicament(String nom) {

		return medicamenRepository.findByNomMedicament(nom);
	}

	@Override
	public List<Medicament> findByNomMedicamentContains(String nom) {
		
		
		return medicamenRepository.findByNomMedicamentContains(nom);
	}

	@Override
	public List<Medicament> findByNomPrix(String nom, Double prix) {
		
		return medicamenRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Medicament> findByForme(Forme forme) {
		
		return medicamenRepository.findByForme(forme);
	}

	@Override
	public List<Medicament> findByFormeIdForme(Long id) {
		
		return medicamenRepository.findByFormeIdforme(id);
				
		
	}

	@Override
	public List<Medicament> findByOrderByNomMedicamentAsc() {
		
		return medicamenRepository.findByOrderByNomMedicamentAsc();
	}

	@Override
	public List<Medicament> trierMedicamentsNomsPrix() {
		
		return medicamenRepository.trierMedicamentsNomsPrix();
	}
	
	

}
