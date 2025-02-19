package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.FactureRequest;
import com.devoir.copres.dtoResponse.FactureResponse;

public interface FactureController  {
	
	@PostMapping()
	public ResponseEntity<FactureResponse> save(@RequestBody FactureRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FactureResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<FactureResponse> update(@RequestBody FactureRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
