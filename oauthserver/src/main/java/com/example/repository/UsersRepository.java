package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByName(String name);

}
