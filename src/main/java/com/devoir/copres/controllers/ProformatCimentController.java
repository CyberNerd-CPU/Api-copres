package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.ProformatCimentRequest;
import com.devoir.copres.dtoResponse.ProformatCimentResponse;

public interface ProformatCimentController {
	
	@PostMapping()
	public ResponseEntity<ProformatCimentResponse> save(@RequestBody ProformatCimentRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProformatCimentResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<ProformatCimentResponse> update(@RequestBody ProformatCimentRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);
}
