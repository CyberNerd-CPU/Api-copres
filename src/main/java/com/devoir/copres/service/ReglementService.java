package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.ReglementRequest;
import com.devoir.copres.dtoResponse.ReglementResponse;

public interface ReglementService {
	
	public ReglementResponse save(ReglementRequest request);
	
	public List<ReglementResponse> getAll();
	
	public ReglementResponse update(ReglementRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
