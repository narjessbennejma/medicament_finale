package com.example.medicament.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.medicament.entities.Forme;
import com.example.medicament.entities.Medicament;


@RepositoryRestResource(path = "rest")
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
	 @Query("select m from Medicament m where m.nomMedicament like 'm'")

	List<Medicament> findByNomMedicament(String nom);
	 
	 List<Medicament> findByNomMedicamentContains(String nom); 
	 
	 @Query("select m from Medicament m where m.nomMedicament like %?1 and m.prixMedicament > ?2")
	 List<Medicament> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select m from Medicament m where m.forme = ?1")
	 List<Medicament> findByForme (Forme forme);
	 List<Medicament> findByFormeIdforme(Long id);
	 List<Medicament> findByOrderByNomMedicamentAsc();
	 @Query("select m from Medicament m order by m.nomMedicament ASC, m.prixMedicament DESC")
	 List<Medicament> trierMedicamentsNomsPrix ();


}
