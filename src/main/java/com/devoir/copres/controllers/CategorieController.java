package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.CategorieRequest;

import com.devoir.copres.dtoResponse.CategorieResponse;


public interface CategorieController {
	
	@PostMapping()
	public ResponseEntity<CategorieResponse> save(@RequestBody CategorieRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategorieResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<CategorieResponse> update(@RequestBody CategorieRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
