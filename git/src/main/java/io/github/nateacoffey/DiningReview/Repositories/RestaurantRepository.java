package io.github.nateacoffey.DiningReview.Repositories;


import org.springframework.data.repository.CrudRepository;

import io.github.nateacoffey.DiningReview.Entities.Restaurant;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
