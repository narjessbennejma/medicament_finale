package com.example.medicament.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.medicament.entities.Forme;
import com.example.medicament.repos.FormeRepository;

@Service
public class FormeServiceImpl implements FormeServices{
	
	@Autowired
	FormeRepository formeRepository ;

	@Override
	public List<Forme> getAllFormes() {
		
		return formeRepository.findAll();
	}

	@Override
	public Forme saveForme(Forme forme) {
		
		return formeRepository.save(forme);
	}

	@Override
	public Page<Forme> getAllFormesParPage(int page, int size) {
		
		return formeRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public void deleteFormeById(Long id) {
		formeRepository.deleteById(id);
		
	}

	@Override
	public Forme getFormes(Long id) {
		
		return formeRepository.findById(id).get();
	}

	@Override
	public Forme updateFormes(Forme f) {
		
		return formeRepository.save(f);
	}

	@Override
	public List<Forme> findAll() {
		return formeRepository.findAll();
	}

}
