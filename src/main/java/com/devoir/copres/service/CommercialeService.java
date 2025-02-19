package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.CommercialeRequest;
import com.devoir.copres.dtoResponse.CommercialeResponse;

public interface CommercialeService {
	
	public CommercialeResponse save(CommercialeRequest request);
	
	public List<CommercialeResponse> getAll();
	
	public CommercialeResponse update(CommercialeRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
