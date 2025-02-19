package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.BonLivraisonRequest;
import com.devoir.copres.dtoResponse.BonLivraisonResponse;

public interface BonLivraisonService {
	
	
	public BonLivraisonResponse save(BonLivraisonRequest request);
	
	public List<BonLivraisonResponse> getAll();
	
	public BonLivraisonResponse update(BonLivraisonRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
