package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.ClientRequest;
import com.devoir.copres.dtoResponse.ClientResponse;

public interface ClientController {
	
	@PostMapping()
	public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ClientResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<ClientResponse> update(@RequestBody ClientRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
