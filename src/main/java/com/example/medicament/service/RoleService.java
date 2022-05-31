package com.example.medicament.service;

import java.util.List;

import com.example.medicament.entities.Role;

public interface RoleService {

	List <Role> findAll();
	Role findByRole(String role);



}