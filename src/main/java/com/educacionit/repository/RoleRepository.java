package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.educacionit.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
