package io.github.nateacoffey.DiningReview.Controllers;


import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Repositories.UserRepository;


@RestController
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
}
