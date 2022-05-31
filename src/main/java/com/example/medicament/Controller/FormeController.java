package com.example.medicament.Controller;

import java.text.ParseException;
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
import com.example.medicament.service.FormeServices;



@Controller
public class FormeController {
	
	@Autowired
	FormeServices  formeService;
	
	@RequestMapping("/showCreateforme")
	public String showCreateCat(ModelMap modelMap)
	{
		modelMap.addAttribute("forme", new Forme());
		modelMap.addAttribute("mode", "new");
		return "formForms";
	}
	
	
	@RequestMapping("/saveForms")
	public String saveForme(@Valid Forme forme,
	BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) return "formForms";
		 
		formeService.saveForme(forme);
		return "redirect:/ListeForme";
	}
	
	
	@RequestMapping("/ListeForme")
	public String listeForms(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
	Page<Forme> form = formeService.getAllFormesParPage(page, size);
	modelMap.addAttribute("formes", form);
	 modelMap.addAttribute("pages", new int[form.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeFormes"; 
	}
	
	
	@RequestMapping("/supprimerFormes")
	public String supprimerFormes(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)
	{
		formeService.deleteFormeById(id);
	Page<Forme> form = formeService.getAllFormesParPage(page, size);
	modelMap.addAttribute("formes", form);
	modelMap.addAttribute("pages", new int[form.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "redirect:/ListeForme";
	}
	
	@RequestMapping("/modifierForme")
	public String editerCategorie(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Forme f= formeService.getFormes(id);
	modelMap.addAttribute("forme", f);
	modelMap.addAttribute("mode", "edit");
	return "formForms";
	}

	@RequestMapping("/updateForme")
	public String updateCategorie(@ModelAttribute("forme") Forme forme,
	
	ModelMap modelMap) throws ParseException 
	{
	 formeService.updateFormes(forme);
	 List<Forme> form = formeService.getAllFormes();
	 modelMap.addAttribute("formes", form);
	 return "listeFormes";
	
   }
	
	
	
	

}
