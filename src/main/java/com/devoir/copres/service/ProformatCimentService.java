package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.ProformatCimentRequest;
import com.devoir.copres.dtoResponse.ProformatCimentResponse;

public interface ProformatCimentService {
	
	public ProformatCimentResponse save(ProformatCimentRequest request);
	
	public List<ProformatCimentResponse> getAll();
	
	public ProformatCimentResponse update(ProformatCimentRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
