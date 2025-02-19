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

import com.devoir.copres.controllers.EtatVenteController;
import com.devoir.copres.dtoRequest.EtatVenteRequest;
import com.devoir.copres.dtoResponse.EtatVenteResponse;
import com.devoir.copres.service.EtatVenteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/etatVente")
public class EtatVenteControllerImpl implements EtatVenteController {
	
EtatVenteService service;
	
	

	public EtatVenteControllerImpl(EtatVenteService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<EtatVenteResponse> save(@RequestBody EtatVenteRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<EtatVenteResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<EtatVenteResponse> update(@RequestBody EtatVenteRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
