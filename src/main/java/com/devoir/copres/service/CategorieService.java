package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.CategorieRequest;
import com.devoir.copres.dtoResponse.CategorieResponse;

public interface CategorieService {
	
	public CategorieResponse save(CategorieRequest request);
	
	public List<CategorieResponse> getAll();
	
	public CategorieResponse update(CategorieRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
