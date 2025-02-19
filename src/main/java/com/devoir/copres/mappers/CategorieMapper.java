package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.CategorieRequest;
import com.devoir.copres.dtoResponse.CategorieResponse;
import com.devoir.copres.model.Categorie;

@Component
public class CategorieMapper  {
	
	
	public Categorie toEntity(CategorieRequest request) {
		
		Categorie entity = new Categorie();
		entity.setTrackingId(UUID.randomUUID());
		entity.setLibelle(request.libelle());
		entity.setDescription(request.description());
		
		return entity;
		
	}
	
	public CategorieResponse toResponse( Categorie entity) {
		
		CategorieResponse response = new CategorieResponse(entity.getTrackingId(),entity.getLibelle(),entity.getDescription());
		
		return response;
		
		
	}
	

}
