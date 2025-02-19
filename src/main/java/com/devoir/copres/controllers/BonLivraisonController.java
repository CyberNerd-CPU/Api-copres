package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.BonLivraisonRequest;
import com.devoir.copres.dtoResponse.BonLivraisonResponse;


public interface BonLivraisonController {
	
	
	public ResponseEntity<BonLivraisonResponse> save(@RequestBody BonLivraisonRequest request);
	
	
	public ResponseEntity<List<BonLivraisonResponse>> getAll();
	
	
	public ResponseEntity<BonLivraisonResponse> update(@RequestBody BonLivraisonRequest request, @PathVariable UUID trackingId);
	
	
	public void delete(@PathVariable UUID trackingId);

}
