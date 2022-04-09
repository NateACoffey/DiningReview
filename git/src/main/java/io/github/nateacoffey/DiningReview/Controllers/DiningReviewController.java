package io.github.nateacoffey.DiningReview.Controllers;


import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Repositories.DiningReviewRepository;


@RestController
public class DiningReviewController {

	private final DiningReviewRepository diningReviewRepository;
	
	public DiningReviewController(final DiningReviewRepository diningReviewRepository) {
		this.diningReviewRepository = diningReviewRepository;
	}
	
	
}
