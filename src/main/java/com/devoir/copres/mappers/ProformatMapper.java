package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.ProformatRequest;
import com.devoir.copres.dtoResponse.ProformatResponse;
import com.devoir.copres.model.Proformat;
import com.devoir.copres.repository.ClientRepository;

@Component
public class ProformatMapper  {
	
	private final ClientRepository clientRepo;
	
	
	
	
	
	public ProformatMapper(ClientRepository clientRepo) {
		
		this.clientRepo = clientRepo;
		
	}

	public Proformat toEntity(ProformatRequest request) {
		
		Proformat entity = new Proformat();
		entity.setTrackingId(UUID.randomUUID());
		entity.setMontantTotal(request.montantTotal());
		
		entity.setStatut(request.statut());
		
		entity.setClient(clientRepo.findByTrackingId(request.clientId()).get());
		
		
		
		return entity;
		
	}
	
	public ProformatResponse toResponse( Proformat entity) {
		
		ProformatResponse response = new ProformatResponse(
				entity.getTrackingId(),
				entity.getMontantTotal(),
				entity.getStatut(),
				entity.getClient().getTrackingId());
		
		return response;
		
		
	}
	

}
