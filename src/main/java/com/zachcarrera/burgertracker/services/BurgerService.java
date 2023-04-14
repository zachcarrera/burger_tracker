package com.zachcarrera.burgertracker.services;

import java.util.List;
import java.util.Optional;

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
	
	// ----- FIND ONE -----
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}
	
	
	
	// ----- CREATE -----
	public Burger createBurger(Burger newBurger) {
		return burgerRepository.save(newBurger);
	}

	// ----- UPDATE -----
	public Burger updateBurger(Burger oneBurger) {
		return burgerRepository.save(oneBurger);
	}

}
