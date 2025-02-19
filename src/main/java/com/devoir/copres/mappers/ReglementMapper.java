package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.ReglementRequest;
import com.devoir.copres.dtoResponse.ReglementResponse;
import com.devoir.copres.model.Reglement;
import com.devoir.copres.repository.FactureRepository;
import com.devoir.copres.repository.ModePayementRepository;

@Component
public class ReglementMapper {
	
	private final FactureRepository factureRepo;
	private final ModePayementRepository modePayementRepo;
	
	
	
	
	
	public ReglementMapper(FactureRepository FactureRepo,ModePayementRepository modePayement) {
		
		this.factureRepo = FactureRepo;
		this.modePayementRepo = modePayement;
		
	}

	public Reglement toEntity(ReglementRequest request) {
		
		Reglement entity = new Reglement();
		entity.setTrackingId(UUID.randomUUID());
		entity.setMontantTotal(request.montantTotal());
		
		entity.setDateReglement(request.dateReglement());
		
		entity.setFacture(factureRepo.findByTrackingId(request.factureId()).get());
		entity.setModePayement(modePayementRepo.findByTrackingId(request.modePayementId()).get());
		
		
		
		return entity;
		
	}
	
	public ReglementResponse toResponse( Reglement entity) {
		
		ReglementResponse response = new ReglementResponse(
				entity.getTrackingId(),
				entity.getMontantTotal(),
				entity.getDateReglement(),
				entity.getFacture().getTrackingId(),
				entity.getModePayement().getTrackingId()
				);
		
		return response;
		
		
	}
	

}
