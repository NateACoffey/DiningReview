package io.github.nateacoffey.DiningReview.Repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.nateacoffey.DiningReview.Entities.User;


public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByDisplayName(String displayName);
}
