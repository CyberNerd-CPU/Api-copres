package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.ProformatRequest;
import com.devoir.copres.dtoResponse.ProformatResponse;

public interface ProformatController {
	
	@PostMapping()
	public ResponseEntity<ProformatResponse> save(@RequestBody ProformatRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProformatResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<ProformatResponse> update(@RequestBody ProformatRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
