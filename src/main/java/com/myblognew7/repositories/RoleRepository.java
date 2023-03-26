package com.myblognew7.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblognew7.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByUsername(String username);
}
