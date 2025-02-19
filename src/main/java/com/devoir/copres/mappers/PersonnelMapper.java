package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.PersonnelRequest;
import com.devoir.copres.dtoResponse.PersonnelResponse;
import com.devoir.copres.model.Personnel;

@Component
public class PersonnelMapper {
	
	
	public Personnel toEntity(PersonnelRequest request) {
		
		Personnel entity = new Personnel();
		entity.setTrackingId(UUID.randomUUID());
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		entity.setMatricle(request.matricle());
		
		return entity;
		
	}
	
	public PersonnelResponse toResponse( Personnel entity) {
		
		PersonnelResponse response = new PersonnelResponse(entity.getTrackingId(),entity.getNom(),entity.getPrenom(),entity.getNumeroCni(),entity.getAdresse(),entity.getTelephone(),entity.getMatricle());
		
		return response;
		
		
	}
	

}
