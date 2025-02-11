package com.project.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.entites.User;

public interface UserService {

    User createUser(User user);
    User updateUser(User user , Long id);
	User getUserById(Long id);
	String delete(Long id);
	Page<User> getAll(Pageable pageable);
	
	
}
