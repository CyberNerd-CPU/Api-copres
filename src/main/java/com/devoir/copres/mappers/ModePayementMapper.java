package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.ModePayementRequest;
import com.devoir.copres.dtoResponse.ModePayementResponse;
import com.devoir.copres.model.ModePayement;

@Component
public class ModePayementMapper  {
	
	
	public ModePayement toEntity(ModePayementRequest request) {
		
		ModePayement entity = new ModePayement();
		entity.setTrackingId(UUID.randomUUID());
		entity.setLibelle(request.libelle());
		entity.setDescription(request.description());
		
		return entity;
		
	}
	
	public ModePayementResponse toResponse( ModePayement entity) {
		
		ModePayementResponse response = new ModePayementResponse(entity.getTrackingId(),entity.getLibelle(),entity.getDescription());
		
		return response;
		
		
	}
	

}
