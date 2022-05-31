package com.example.medicament.repos;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.medicament.entities.Forme;


@RepositoryRestResource(path = "rest")

public interface FormeRepository extends JpaRepository<Forme, Long> {

		 
}
