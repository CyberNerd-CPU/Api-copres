package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.FactureRequest;
import com.devoir.copres.dtoResponse.FactureResponse;
import com.devoir.copres.model.Facture;

import com.devoir.copres.repository.ProformatRepository;

@Component
public class FactureMapper   {
	
	private final ProformatRepository proformatRepo;
	
	
	
	
	
	public FactureMapper(ProformatRepository proformatRepo) {
		
		this.proformatRepo = proformatRepo;
		
	}

	public Facture toEntity(FactureRequest request) {
		
		Facture entity = new Facture();
		entity.setTrackingId(UUID.randomUUID());
		entity.setMontantTotal(request.montantTotal());
		
		entity.setEcheance_date(request.echeance_date());
		entity.setMontantPayer(request.montantPayer());
		entity.setProformat(proformatRepo.findByTrackingId(request.proformatId()).get());
		
		
		
		return entity;
		
	}
	
	public FactureResponse toResponse( Facture entity) {
		
		FactureResponse response = new FactureResponse(
				entity.getTrackingId(),
				entity.getEcheance_date(),
				entity.getMontantTotal(),
				entity.getMontantPayer(),
				entity.getProformat().getTrackingId());
		
		return response;
		
		
	}
	

}
