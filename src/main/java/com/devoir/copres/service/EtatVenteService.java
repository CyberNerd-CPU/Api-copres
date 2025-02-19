package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.EtatVenteRequest;
import com.devoir.copres.dtoResponse.EtatVenteResponse;

public interface EtatVenteService {
	
	public EtatVenteResponse save(EtatVenteRequest request);
	
	public List<EtatVenteResponse> getAll();
	
	public EtatVenteResponse update(EtatVenteRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
