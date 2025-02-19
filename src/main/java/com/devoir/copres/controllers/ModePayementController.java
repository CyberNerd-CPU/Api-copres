package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.ModePayementRequest;
import com.devoir.copres.dtoResponse.ModePayementResponse;

public interface ModePayementController {
	
	@PostMapping()
	public ResponseEntity<ModePayementResponse> save(@RequestBody ModePayementRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ModePayementResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<ModePayementResponse> update(@RequestBody ModePayementRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
