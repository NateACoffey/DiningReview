package io.github.nateacoffey.DiningReview.Repositories;


import org.springframework.data.repository.CrudRepository;

import io.github.nateacoffey.DiningReview.Entities.DiningReview;


public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {

}
