package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.entites.Patient;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.PatientRepository;



import javax.validation.Valid;

@Controller

public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository; 
	
	@GetMapping(path="/index")
	private String index() {
		return "index";
	}

	
	
	@GetMapping(path="/patients")
	private String liste(  Model model,
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "5") int size,
			@RequestParam(name="keyword", defaultValue = "") String mc  ) 
	{
		Page<Patient> pagePatients = patientRepository.findByNameContains(mc, PageRequest.of(page, size));
		model.addAttribute("patients",pagePatients.getContent());
		model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("keyword", mc);
		return "patients";
	}
	
	@GetMapping(path="/deletePatient")
	private String delete(Long id,String keyword,int page,int size ) {
		patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}
	
	
	@GetMapping(path="/deletePatient1")
	private String delete2(Long id,String keyword,int page,int size,Model model ) {
		patientRepository.deleteById(id);
		return liste(model, page, size, keyword);
	}
	
	@GetMapping(path="/formPatients")
	public String formPatients(Model model) {
		model.addAttribute("patient",new Patient());
		model.addAttribute("mode","new");
		return "formPatients";
	}
	
	@PostMapping(path="/savePatient")
	public String savePatient(@Valid Patient patient ,BindingResult bindingResult ) {; 
		if(bindingResult.hasErrors()) 
			{return "formPatients";}
		patientRepository.save( patient); 
		return "formPatients";
	}
	
	@GetMapping(path="/editPatient")
	public String editmPatients(Model model,Long id) {
		Patient p= patientRepository.findById(id).get();
		model.addAttribute("mode","edit");
	
		model.addAttribute("patient",p);
		return "formPatients";
	}
		
	
}
