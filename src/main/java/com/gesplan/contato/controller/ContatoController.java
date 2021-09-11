package com.gesplan.contato.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gesplan.contato.entity.Contato;
import com.gesplan.contato.form.ContatoDTO;
import com.gesplan.contato.services.ContatoService;

@Controller
public class ContatoController {

	
	@Autowired 
	private ContatoService contatoService; 

	@GetMapping({ "/list", "/" })
	public ModelAndView getAllContatos() {
		ModelAndView mav = new ModelAndView("contatos");		
		mav.addObject("contatos", contatoService.findAll());		
		return mav;
	}
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long contatoId) {
		ModelAndView mav = new ModelAndView("update");		
		Contato contato = contatoService.find(contatoId);
		mav.addObject("contato", contato);
		return mav;
	}

	@PostMapping("/saveContato")
	public String saveContato(@ModelAttribute ContatoDTO contato) {
		contato.setId(null);		
		contatoService.insert(contatoService.fromDTO(contato));
		return "redirect:/list";
	}
	
	@PostMapping("/updateContato")
	public String updateContato(@ModelAttribute ContatoDTO contato) {		
		contatoService.update(contatoService.fromDTO(contato));		
		return "redirect:/list";
	}

	@GetMapping("/deleteContato")
	public String deleteContato(@RequestParam Long contatoId) {		
		contatoService.delete(contatoId);
		return "redirect:/list";
	}
}