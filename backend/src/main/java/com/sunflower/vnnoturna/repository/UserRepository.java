package com.sunflower.vnnoturna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunflower.vnnoturna.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
