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

import com.devoir.copres.controllers.ReglementController;
import com.devoir.copres.dtoRequest.ReglementRequest;
import com.devoir.copres.dtoResponse.ReglementResponse;
import com.devoir.copres.service.ReglementService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/reglement")
public class ReglementControllerImpl implements ReglementController {
	
ReglementService service;
	
	

	public ReglementControllerImpl(ReglementService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<ReglementResponse> save(@RequestBody ReglementRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<ReglementResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<ReglementResponse> update(@RequestBody ReglementRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
