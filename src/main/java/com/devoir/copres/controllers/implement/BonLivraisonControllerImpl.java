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

import com.devoir.copres.controllers.BonLivraisonController;
import com.devoir.copres.dtoRequest.BonLivraisonRequest;
import com.devoir.copres.dtoResponse.BonLivraisonResponse;
import com.devoir.copres.service.BonLivraisonService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/bonLivraison")
public class BonLivraisonControllerImpl implements BonLivraisonController {
	
	BonLivraisonService service;
	
	

	public BonLivraisonControllerImpl(BonLivraisonService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<BonLivraisonResponse> save(@RequestBody BonLivraisonRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<BonLivraisonResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<BonLivraisonResponse> update(@RequestBody BonLivraisonRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;
	

	
	
	

}
