package com.daniel.TodoList.services;

import com.daniel.TodoList.models.ERole;
import com.daniel.TodoList.models.Role;
import com.daniel.TodoList.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findByName(ERole role){
        return roleRepository.findByName(role);
    }
}
