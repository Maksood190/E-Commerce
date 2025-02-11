package com.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.Exception.UserNotFoundException;
import com.project.Repository.UserRepository;
import com.project.entites.User;


@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, Long id) {

		Optional<User> exsist= userRepository.findById(id);
		if(exsist.isPresent()) {
			User user2 = exsist.get();
			user2.setUsername(user.getUsername());
			user2.setPassword(user.getPassword());
			return userRepository.save(user);
		}
		
		else {
			throw new UserNotFoundException("User is not found with id:"+id);
		}
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id)
				.orElseThrow(()-> new  UserNotFoundException("User is not found with id:"+id));
	}

	@Override
	public String delete(Long id) {
		if(userRepository.existsById(id)){
			new UserNotFoundException("User is not found with id: "+id);
		}
		return "User is deleted successfully with id:"+id;
	}

	@Override
	public Page<User> getAll(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

}
