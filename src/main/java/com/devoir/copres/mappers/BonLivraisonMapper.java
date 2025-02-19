package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.BonLivraisonRequest;
import com.devoir.copres.dtoResponse.BonLivraisonResponse;
import com.devoir.copres.model.BonLivraison;

@Component
public class BonLivraisonMapper  {
	
	
	public BonLivraison toEntity(BonLivraisonRequest request) {
		
		BonLivraison entity = new BonLivraison();
		entity.setTrackingId(UUID.randomUUID());
		entity.setNumeroBon(request.numeroBon());
		entity.setDateLivraison(request.dateLivraison());
		entity.setStatut(request.statut());
		entity.setAdresseLivraison(request.adresseLivraison());
		
		return entity;
		
	}
	
	public BonLivraisonResponse toResponse( BonLivraison entity) {
		
		BonLivraisonResponse response = new BonLivraisonResponse(entity.getTrackingId(),entity.getNumeroBon(),entity.getDateLivraison(),entity.getStatut(),entity.getAdresseLivraison());
		
		return response;
		
		
	}
	

}
