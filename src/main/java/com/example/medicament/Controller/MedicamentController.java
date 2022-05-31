package com.example.medicament.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.medicament.entities.Forme;
import com.example.medicament.entities.Medicament;
import com.example.medicament.service.FormeServices;
import com.example.medicament.service.MedicamentService;


@Controller
public class MedicamentController {
	@Autowired
	MedicamentService medicamentService;
	@Autowired
	FormeServices formeService;

	/*@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("medicament", new Medicament());
	modelMap.addAttribute("mode", "new");
	return "formMedicament";
	}*/
	
	@RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap)
    {
        List<Forme> forms = formeService.getAllFormes();
        Medicament med = new Medicament();
        Forme form = new Forme();
        form = forms.get(0); // prendre la première catégorie de la liste
        med.setForme(form); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
        modelMap.addAttribute("medicament",med);
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("formes", forms);
        return "formMedicament";
    }
	

	@RequestMapping("/saveMedicament")
	public String saveMedicament(@Valid Medicament medicament,
	BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formMedicament";
	 
	medicamentService.saveMedicament(medicament);
	return "redirect:/ListeMedicaments";
	
	}


	@RequestMapping("/ListeMedicaments")
	public String listeMedicaments(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		
		Page<Medicament> med = medicamentService.getAllMedicamentsParPage(page, size);
		 List<Forme> forms = formeService.getAllFormes();
		modelMap.addAttribute("formes", forms);
		modelMap.addAttribute("medicaments", med);
		modelMap.addAttribute("pages", new int[med.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMedicaments";
	}

	@RequestMapping("/supprimerMedicament")
	public String supprimerMedicament(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		medicamentService.deleteMedicamentById(id);
	Page<Medicament> med = medicamentService.getAllMedicamentsParPage(page, size);
	modelMap.addAttribute("medicaments", med);
	modelMap.addAttribute("pages", new int[med.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeMedicaments";
	}

	@RequestMapping("/modifierMedicament")
	public String editerMedicament(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Medicament m= medicamentService.getMedicament(id);
	modelMap.addAttribute("medicament", m);
	modelMap.addAttribute("mode", "edit");
	 List<Forme> forms = formeService.getAllFormes() ;
	    modelMap.addAttribute("formes", forms);
	return "formMedicament";
	}


	@RequestMapping("/updateMedicament")
	public String updateProduit(@ModelAttribute("medicament") Medicament medicament,
			@RequestParam("dateexpiration") String datee, @RequestParam("dateCreation") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		medicament.setDateCreation(dateCreation);
		Date dateexpiration = dateformat.parse(String.valueOf(datee));

		medicament.setDateexpiration(dateexpiration);

		medicamentService.updateMedicament(medicament);
		List<Medicament> med = medicamentService.getAllMedicaments();
		modelMap.addAttribute("medicaments", med);
		return "listeMedicament";

	}
	
	@RequestMapping("/chercherForme")
public String chercherForme(@ModelAttribute("nomM")Medicament formData,ModelMap modelMap, @RequestParam("f") Long f
		) 
	{

List<Forme> forme = formeService.findAll();
modelMap.addAttribute("formes", forme);

List<Medicament> m=medicamentService.findByFormeIdForme(f);
modelMap.addAttribute("medicaments",m);

return "rechercheForme";
}
	
	/*@RequestMapping("/chercherNom")
	public String chercherNom(@RequestParam("nommed") String nom,
	ModelMap modelMap)
	
	{    
	 
	 List <Medicament> m = medicamentService.findByNomMedicamentContains(nom);
	 
	 modelMap.addAttribute("medicament",m);
	 
	 return "recherchenom";
	}*/
	
	@RequestMapping("/chercherNom")
	public String chercherNom(@RequestParam("nommed") String nom,
			ModelMap modelMap)


	{     
		  List <Medicament> m = medicamentService.findByNomMedicamentContains(nom);
		  
		  modelMap.addAttribute("medicament",m);

		  return "recherchenom";
	} 
	
	
	
}
