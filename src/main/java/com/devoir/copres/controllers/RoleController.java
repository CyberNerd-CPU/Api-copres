package com.devoir.copres.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devoir.copres.dtoRequest.RoleRequest;
import com.devoir.copres.dtoResponse.RoleResponse;

public interface RoleController {
	
	@PostMapping()
	public ResponseEntity<RoleResponse> save(@RequestBody RoleRequest request);
	
	@GetMapping("/getAll")
	public ResponseEntity<List<RoleResponse>> getAll();
	
	@PostMapping("/{trakingId}")
	public ResponseEntity<RoleResponse> update(@RequestBody RoleRequest request, @PathVariable UUID trackingId);
	
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId);

}
