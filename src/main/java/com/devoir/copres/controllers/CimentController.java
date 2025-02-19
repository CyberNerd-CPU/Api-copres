package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.CimentRequest;
import com.devoir.copres.dtoResponse.CimentResponse;

public interface CimentController {
	
	@PostMapping()
	public ResponseEntity<CimentResponse> save(@RequestBody CimentRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CimentResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<CimentResponse> update(@RequestBody CimentRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
