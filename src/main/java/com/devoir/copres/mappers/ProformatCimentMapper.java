package com.devoir.copres.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.devoir.copres.dtoRequest.ProformatCimentRequest;
import com.devoir.copres.dtoResponse.ProformatCimentResponse;
import com.devoir.copres.model.ProformatCiment;
import com.devoir.copres.repository.CimentRepository;

import com.devoir.copres.repository.ProformatRepository;

@Component
public class ProformatCimentMapper   {
	
	private final ProformatRepository proformatRepo;
	private final CimentRepository cimRepo;
	
	
	
	
	public ProformatCimentMapper(ProformatRepository proformatRepo, CimentRepository cimRepo) {
		
		this.proformatRepo = proformatRepo;
		this.cimRepo = cimRepo;
	}

	public ProformatCiment toEntity(ProformatCimentRequest request) {
		
		ProformatCiment entity = new ProformatCiment();
		entity.setTrackingId(UUID.randomUUID());
		
		entity.setCiment(cimRepo.findByTrackingId(request.cimentId()).get());
		entity.setProformat(proformatRepo.findByTrackingId(request.proformatId()).get());
		
		
		return entity;
		
	}
	
	public ProformatCimentResponse toResponse( ProformatCiment entity) {
		
		ProformatCimentResponse response = new ProformatCimentResponse(
				entity.getTrackingId(),
				
				entity.getCiment().getTrackingId(),
				entity.getProformat().getTrackingId());
		
		return response;
		
		
	}
	

}
