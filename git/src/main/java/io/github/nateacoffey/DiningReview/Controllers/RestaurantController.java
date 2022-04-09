package io.github.nateacoffey.DiningReview.Controllers;


import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Repositories.RestaurantRepository;


@RestController
public class RestaurantController {
	
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantController(final RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}
	
}
