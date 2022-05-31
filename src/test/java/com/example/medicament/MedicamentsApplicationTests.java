package com.example.medicament;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.medicament.entities.Forme;
import com.example.medicament.entities.Medicament;
import com.example.medicament.repos.MedicamentRepository;
import com.example.medicament.service.MedicamentService;

@SpringBootTest
class MedicamentsApplicationTests {

	
	@Autowired
	private MedicamentRepository medicamentRepository;
	@Autowired
	private MedicamentService medicamentsService;
	
	/*@Test
	public void testCreateMedicament() {
	Medicament med = new Medicament("med1",2200.500,new Date(),new Date());
	medicamentRepository.save(med);
	}*/
	@Test
	public void testUpdateMedicament()
	{
	Medicament m = medicamentRepository.findById(1L).get();
	m.setPrixMedicament(1000.0);
	medicamentRepository.save(m);
	}
	@Test
	public void testDeleteMedicament()
	{
		medicamentRepository.deleteById(2L);;
	}
	 
	@Test
	public void testListerTousMedicament()
	{
	List<Medicament> med = medicamentRepository.findAll();
	for (Medicament m : med)
	{
	System.out.println(m);
	}
	
	}
	@Test
	public void testFindByNomMedicamentContains()
	{
	
	Page<Medicament> prods = medicamentsService.getAllMedicamentsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	
	}
	@Test
	public void testFindByNomProduit()
	{
	List<Medicament> med = medicamentRepository.findByNomMedicament("med");
	for (Medicament m: med)
	{
	System.out.println(m);
	}
	}
	@Test
	public void testFindByNomProduitContains ()
	{
	List<Medicament> med=medicamentRepository.findByNomMedicamentContains(" med");
	for (Medicament m : med)
	{
	System.out.println(m);
	} }

	@Test
	public void testfindByNomPrix()
	{
	List<Medicament> med = medicamentRepository.findByNomPrix("medd1", 200.0);
	for (Medicament m: med)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Forme form = new Forme();
	form.setIdforme(1L);
	List<Medicament> med = medicamentRepository.findByForme(form);
	for (Medicament m : med)
	{
	System.out.println(m);
	}


}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Medicament> med = medicamentRepository.findByFormeIdforme(1l);
	for (Medicament m : med)
	{
	System.out.println(m);
	}
	 }
	@Test
	public void testfindByOrderByMedicamentAsc()
	{
	List<Medicament> med = 
	medicamentRepository.findByOrderByNomMedicamentAsc();
	for (Medicament p : med)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierProduitsNomsPrix()
	{
	List<Medicament> med = medicamentRepository.trierMedicamentsNomsPrix();
	for (Medicament m : med)
	{
	System.out.println(m);
	}
	}

}
