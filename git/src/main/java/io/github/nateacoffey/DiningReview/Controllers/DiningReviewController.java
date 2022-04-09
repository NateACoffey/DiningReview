package io.github.nateacoffey.DiningReview.Controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Entities.DiningReview;
import io.github.nateacoffey.DiningReview.Repositories.DiningReviewRepository;


@RestController
public class DiningReviewController {

	private final DiningReviewRepository diningReviewRepository;
	
	public DiningReviewController(final DiningReviewRepository diningReviewRepository) {
		this.diningReviewRepository = diningReviewRepository;
	}
	
	
	@GetMapping("/dining-review/search")
	public Iterable<DiningReview> getAllPendingApproval(@RequestParam("status") String status){
		
		Iterable<DiningReview> diningReviews = diningReviewRepository.findAllByStatus(status);
		
		return diningReviews;
		
	}
	
	@PostMapping("/dining-review/create")
	public DiningReview createNewReview(@RequestBody DiningReview diningReview) {
		
		//always start new review with a pending status to wait for approval
		diningReview.setStatus("pending");
		
		DiningReview newReview = diningReviewRepository.save(diningReview);
		
		return newReview;
	}
	
	@PutMapping("/dining-review/approve")
	public DiningReview updateApprovalRequests(@RequestParam("id") Long id, @RequestParam("status") String status){
		
		Optional<DiningReview> diningReviewOptional = diningReviewRepository.findById(id);
		
		if(!diningReviewOptional.isPresent()) {
			return null;
		}
		
		DiningReview diningReviewToApprove = diningReviewOptional.get();
		
		diningReviewToApprove.setStatus(status);
		
		DiningReview updatedDiningReview = diningReviewRepository.save(diningReviewToApprove);
		
		
		return updatedDiningReview;
	}
	
	
	
}
