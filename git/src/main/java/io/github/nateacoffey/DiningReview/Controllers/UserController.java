package io.github.nateacoffey.DiningReview.Controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.nateacoffey.DiningReview.Entities.User;
import io.github.nateacoffey.DiningReview.Repositories.UserRepository;


@RestController
public class UserController {
	
	private final UserRepository userRepository;
	
	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@GetMapping("/user/search")
	public Iterable<User> findUserByUsername(@RequestParam("displayName") String displayName) {
		return userRepository.findByDisplayName(displayName);
	}
	
	@PostMapping("/user/add")
	public User createNewUser(@RequestBody User user) {
		
		User newUser = userRepository.save(user);
		
		return newUser;
		
	}
	
	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			return null;
		}
		
		User userToUpdate = optionalUser.get();
		
		if(user.getDairyAllergies() != null) {
			userToUpdate.setDairyAllergies(user.getDairyAllergies());
		}
		if(user.getEggAllergies() != null) {
			userToUpdate.setEggAllergies(user.getEggAllergies());
		}
		if(user.getPeanutAllergies() != null) {
			userToUpdate.setPeanutAllergies(user.getPeanutAllergies());
		}
		if(user.getCity() != null) {
			userToUpdate.setCity(user.getCity());
		}
		if(user.getState() != null) {
			userToUpdate.setState(user.getState());
		}
		if(user.getZipCode() != null) {
			userToUpdate.setZipCode(user.getZipCode());
		}
		
		
		User updatedUser = userRepository.save(userToUpdate);
		
		
		return updatedUser;
	}
	
	
	
}
