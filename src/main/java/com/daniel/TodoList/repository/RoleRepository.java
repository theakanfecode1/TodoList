package com.daniel.TodoList.repository;

import com.daniel.TodoList.models.ERole;
import com.daniel.TodoList.models.Role;
import com.daniel.TodoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);

}
