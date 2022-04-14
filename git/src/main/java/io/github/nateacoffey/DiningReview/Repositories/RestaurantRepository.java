package io.github.nateacoffey.DiningReview.Repositories;


import org.springframework.data.repository.CrudRepository;

import io.github.nateacoffey.DiningReview.Entities.Restaurant;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	Iterable<Restaurant> findByNameAndZipCode(String name, Integer zipCode);
	
	Iterable<Restaurant> findByZipCode(Integer zipCode);
	
	Iterable<Restaurant> findByZipCodeAndPeanutAllergyIsNotNullOrderByPeanutAllergyDesc(Integer zipCode);
	
	Iterable<Restaurant> findByZipCodeAndEggAllergyIsNotNullOrderByEggAllergyDesc(Integer zipCode);
	
	Iterable<Restaurant> findByZipCodeAndDairyAllergyIsNotNullOrderByDairyAllergyDesc(Integer zipCode);
	
	
}
