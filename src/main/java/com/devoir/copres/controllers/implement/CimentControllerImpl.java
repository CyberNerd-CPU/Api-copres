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

import com.devoir.copres.controllers.CimentController;
import com.devoir.copres.dtoRequest.CimentRequest;
import com.devoir.copres.dtoResponse.CimentResponse;
import com.devoir.copres.service.CimentService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/ciment")
public class CimentControllerImpl implements CimentController {
	
CimentService service;
	
	

	public CimentControllerImpl(CimentService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<CimentResponse> save(@RequestBody CimentRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<CimentResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<CimentResponse> update(@RequestBody CimentRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
