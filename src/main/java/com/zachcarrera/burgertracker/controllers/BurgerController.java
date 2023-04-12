package com.zachcarrera.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
}
