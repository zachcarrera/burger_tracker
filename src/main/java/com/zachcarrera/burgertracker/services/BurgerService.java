package com.zachcarrera.burgertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zachcarrera.burgertracker.models.Burger;
import com.zachcarrera.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	@Autowired
	private BurgerRepository burgerRepository;
	
	// ----- FIND ALL -----
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	// ----- CREATE -----
	public Burger createBurger(Burger newBurger) {
		return burgerRepository.save(newBurger);
	}
}
