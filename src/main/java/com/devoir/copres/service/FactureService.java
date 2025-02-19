package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.FactureRequest;
import com.devoir.copres.dtoResponse.FactureResponse;

public interface FactureService {
	
	public FactureResponse save(FactureRequest request);
	
	public List<FactureResponse> getAll();
	
	public FactureResponse update(FactureRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
