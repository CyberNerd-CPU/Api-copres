package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.CimentRequest;
import com.devoir.copres.dtoResponse.CimentResponse;

public interface CimentService {
	
	public CimentResponse save(CimentRequest request);
	
	public List<CimentResponse> getAll();
	
	public CimentResponse update(CimentRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
