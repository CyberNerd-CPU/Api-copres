package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.ProformatRequest;
import com.devoir.copres.dtoResponse.ProformatResponse;

public interface ProformatService {
	
	public ProformatResponse save(ProformatRequest request);
	
	public List<ProformatResponse> getAll();
	
	public ProformatResponse update(ProformatRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
