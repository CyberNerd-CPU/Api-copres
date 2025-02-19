package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.EtatVenteRequest;
import com.devoir.copres.dtoResponse.EtatVenteResponse;
import com.devoir.copres.model.EtatVente;
import com.devoir.copres.repository.CommercialeRepository;
import com.devoir.copres.repository.FactureRepository;

@Component
public class EtatVenteMapper   {
	
	private final CommercialeRepository comRepo;
	private final FactureRepository facRepo;
	
	
	
	
	public EtatVenteMapper(CommercialeRepository comRepo, FactureRepository facRepo) {
		
		this.comRepo = comRepo;
		this.facRepo = facRepo;
	}

	public EtatVente toEntity(EtatVenteRequest request) {
		
		EtatVente entity = new EtatVente();
		entity.setTrackingId(UUID.randomUUID());
		entity.setMontantTotal(request.montantTotal());
		entity.setDateBebut(request.dateBebut());
		entity.setDateFin(request.dateFin());
		entity.setNombreVente(request.nombreVente());
		entity.setCommerciale(comRepo.findByTrackingId(request.commercialeId()).get());
		entity.setFacture(facRepo.findByTrackingId(request.factureId()).get());
		
		
		return entity;
		
	}
	
	public EtatVenteResponse toResponse( EtatVente entity) {
		
		EtatVenteResponse response = new EtatVenteResponse(
				entity.getTrackingId(),
				entity.getMontantTotal(),
				entity.getNombreVente(),
				entity.getDateBebut(),
				entity.getDateFin(),
				entity.getCommerciale().getTrackingId(),
				entity.getFacture().getTrackingId());
		
		return response;
		
		
	}
	

}
