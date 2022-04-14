package io.github.nateacoffey.DiningReview.Controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Entities.Restaurant;
import io.github.nateacoffey.DiningReview.Repositories.RestaurantRepository;


@RestController
public class RestaurantController {
	
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantController(final RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
	
	@GetMapping("/restaurant/{id}")
	public Restaurant getRestaurantById(@PathVariable("id") Long id) {
		
		Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
		
		if(!restaurantOptional.isPresent()) {
			return null;
		}
		
		Restaurant restaurant = restaurantOptional.get();
		
		return restaurant;
	}
	
	@GetMapping("/restaurant/search")
	public Iterable<Restaurant> getRestaurantByZipCode(
			@RequestParam("zipCode") Integer zipCode, 
			@RequestParam(name = "peanutAllergy", required = false) Integer peanutAllergy, 
			@RequestParam(name = "eggAllergy", required = false) Integer eggAllergy, 
			@RequestParam(name = "dairyAllergy", required = false) Integer dairyAllergy) {
		
		
		if(peanutAllergy == null && eggAllergy == null && dairyAllergy == null) {
			Iterable<Restaurant> restaurant = restaurantRepository.findByZipCode(zipCode);
			
			return restaurant;
		}
		
		if(peanutAllergy != null) {
			Iterable<Restaurant> restaurant = restaurantRepository.findByZipCodeAndPeanutAllergyIsNotNullOrderByPeanutAllergyDesc(zipCode);
			
			return restaurant;
		}
		
		if(eggAllergy != null) {
			Iterable<Restaurant> restaurant = restaurantRepository.findByZipCodeAndEggAllergyIsNotNullOrderByEggAllergyDesc(zipCode);
			
			return restaurant;
		}
		
		if(dairyAllergy != null) {
			Iterable<Restaurant> restaurant = restaurantRepository.findByZipCodeAndDairyAllergyIsNotNullOrderByDairyAllergyDesc(zipCode);
			
			return restaurant;
		}
		
		
		return null;
	}
	
	@PostMapping("/restaurant/create")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		
		
		Iterable<Restaurant> nameAndZipCodeRestaurant = restaurantRepository.findByNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
		
		if(nameAndZipCodeRestaurant.iterator().hasNext()) {
			return null;
		}
		
		Restaurant newRestaurant = restaurantRepository.save(restaurant);
		
		return newRestaurant;
	}
	
	
}
