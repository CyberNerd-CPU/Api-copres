package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.ClientRequest;
import com.devoir.copres.dtoResponse.ClientResponse;
import com.devoir.copres.model.Client;

@Component
public class ClientMapper   {
	
	
	public Client toEntity(ClientRequest request) {
		
		Client entity = new Client();
		entity.setTrackingId(UUID.randomUUID());
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		
		return entity;
		
	}
	
	public ClientResponse toResponse( Client entity) {
		
		ClientResponse response = new ClientResponse(entity.getTrackingId(),entity.getNom(),entity.getPrenom(),entity.getNumeroCni(),entity.getAdresse(),entity.getTelephone());
		
		return response;
		
		
	}
	

}
