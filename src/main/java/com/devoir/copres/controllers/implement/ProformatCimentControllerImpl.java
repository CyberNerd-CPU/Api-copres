package com.devoir.copres.controllers.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devoir.copres.controllers.ProformatCimentController;
import com.devoir.copres.dtoRequest.ProformatCimentRequest;
import com.devoir.copres.dtoResponse.ProformatCimentResponse;
import com.devoir.copres.service.ProformatCimentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/proformatCiment")
public class ProformatCimentControllerImpl implements ProformatCimentController {
	
ProformatCimentService service;
	
	

	public ProformatCimentControllerImpl(ProformatCimentService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<ProformatCimentResponse> save(@RequestBody ProformatCimentRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<ProformatCimentResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<ProformatCimentResponse> update(@RequestBody ProformatCimentRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
