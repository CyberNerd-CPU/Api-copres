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

import com.devoir.copres.controllers.CommercialeController;
import com.devoir.copres.dtoRequest.CommercialeRequest;
import com.devoir.copres.dtoResponse.CommercialeResponse;
import com.devoir.copres.service.CommercialeService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/commerciale")
public class CommercialeControllerImpl implements CommercialeController {
	
CommercialeService service;
	
	

	public CommercialeControllerImpl(CommercialeService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<CommercialeResponse> save(@RequestBody CommercialeRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<CommercialeResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<CommercialeResponse> update(@RequestBody CommercialeRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
