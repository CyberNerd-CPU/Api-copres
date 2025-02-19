package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.CommercialeRequest;
import com.devoir.copres.dtoResponse.CommercialeResponse;

public interface CommercialeController {
	
	@PostMapping()
	public ResponseEntity<CommercialeResponse> save(@RequestBody CommercialeRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CommercialeResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<CommercialeResponse> update(@RequestBody CommercialeRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
