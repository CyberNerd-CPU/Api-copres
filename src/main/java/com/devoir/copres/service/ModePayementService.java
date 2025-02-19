package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.ModePayementRequest;
import com.devoir.copres.dtoResponse.ModePayementResponse;

public interface ModePayementService {
	
	public ModePayementResponse save(ModePayementRequest request);
	
	public List<ModePayementResponse> getAll();
	
	public ModePayementResponse update(ModePayementRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
