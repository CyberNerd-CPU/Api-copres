package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.CommercialeRequest;
import com.devoir.copres.dtoResponse.CommercialeResponse;
import com.devoir.copres.model.Commerciale;

@Component
public class CommercialeMapper   {
	
	
	public Commerciale toEntity(CommercialeRequest request) {
		
		Commerciale entity = new Commerciale();
		entity.setTrackingId(UUID.randomUUID());
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		entity.setMatricle(request.matricle());
		
		return entity;
		
	}
	
	public CommercialeResponse toResponse( Commerciale entity) {
		
		CommercialeResponse response = new CommercialeResponse(entity.getTrackingId(),entity.getNom(),entity.getPrenom(),entity.getNumeroCni(),entity.getAdresse(),entity.getTelephone(),entity.getMatricle());
		
		return response;
		
		
	}
	

}
