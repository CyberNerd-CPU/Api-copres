package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.RoleRequest;
import com.devoir.copres.dtoResponse.RoleResponse;
import com.devoir.copres.model.Role;

@Component
public class RoleMapper  {
	
	
	public Role toEntity(RoleRequest request) {
		
		Role entity = new Role();
		entity.setTrackingId(UUID.randomUUID());
		entity.setLibelle(request.libelle());
		entity.setCode(request.code());
		
		return entity;
		
	}
	
	public RoleResponse toResponse( Role entity) {
		
		RoleResponse response = new RoleResponse(entity.getTrackingId(),entity.getLibelle(),entity.getCode());
		
		return response;
		
		
	}
	

}
