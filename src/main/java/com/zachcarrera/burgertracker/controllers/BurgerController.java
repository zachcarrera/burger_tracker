package com.zachcarrera.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zachcarrera.burgertracker.models.Burger;
import com.zachcarrera.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	private BurgerService burgerService;

	@GetMapping("/")
	public String index(Model model, @ModelAttribute("newBurger") Burger newBurger) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}

	@PostMapping("/burgers/new")
	public String create(Model model, @Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("burgers", burgerService.allBurgers());
			return "index.jsp";
		}

		burgerService.createBurger(newBurger);
		return "redirect:/";
	}

	@GetMapping("/burgers/edit/{id}")
	public String renderEdit(@PathVariable("id") Long id, Model model) {
		
		Burger oneBurger = burgerService.findBurger(id);
		model.addAttribute("oneBurger", oneBurger);
	
		return "edit.jsp";
		
	}

	@PutMapping("/burgers/edit/{id}")
	public String processEdit(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("oneBurger") Burger oneBurger,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		burgerService.updateBurger(oneBurger);

		return "redirect:/";
	}
	
}
