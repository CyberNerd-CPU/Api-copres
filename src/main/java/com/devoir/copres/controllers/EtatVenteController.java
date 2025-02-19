package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.EtatVenteRequest;
import com.devoir.copres.dtoResponse.EtatVenteResponse;

public interface EtatVenteController {
	
	@PostMapping()
	public ResponseEntity<EtatVenteResponse> save(@RequestBody EtatVenteRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EtatVenteResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<EtatVenteResponse> update(@RequestBody EtatVenteRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
