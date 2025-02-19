package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.ReglementRequest;
import com.devoir.copres.dtoResponse.ReglementResponse;

public interface ReglementController {
	
	@PostMapping()
	public ResponseEntity<ReglementResponse> save(@RequestBody ReglementRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ReglementResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<ReglementResponse> update(@RequestBody ReglementRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
