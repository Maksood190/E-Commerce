package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entites.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
