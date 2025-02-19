package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.CimentRequest;
import com.devoir.copres.dtoResponse.CimentResponse;
import com.devoir.copres.model.Ciment;
import com.devoir.copres.repository.CategorieRepository;

@Component
public class CimentMapper   {
	
	private final CategorieRepository catRepo;
	
	
	
	
	
	public CimentMapper(CategorieRepository catRepo) {
		
		this.catRepo = catRepo;
	}

	public Ciment toEntity(CimentRequest request) {
		
		Ciment entity = new Ciment();
		entity.setTrackingId(UUID.randomUUID());
		entity.setLibelle(request.libelle());
		entity.setPrixUnitaire(request.prixUnitaire());
		entity.setQuantite(request.quantite());
		entity.setCategorie(catRepo.findByTrackingId(request.categorieId()).get());
		
		return entity;
		
	}
	
	public CimentResponse toResponse( Ciment entity) {
		
		CimentResponse response = new CimentResponse(entity.getTrackingId(),entity.getLibelle(),entity.getPrixUnitaire(),entity.getQuantite(),entity.getCategorie().getTrackingId(),entity.getCategorie().getLibelle());
		
		return response;
		
		
	}
	

}
