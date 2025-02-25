package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
