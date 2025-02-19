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

import com.devoir.copres.controllers.ModePayementController;
import com.devoir.copres.dtoRequest.ModePayementRequest;
import com.devoir.copres.dtoResponse.ModePayementResponse;
import com.devoir.copres.service.ModePayementService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/modePayement")
public class ModePayementControllerImpl implements ModePayementController {
	
ModePayementService service;
	
	

	public ModePayementControllerImpl(ModePayementService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<ModePayementResponse> save(@RequestBody ModePayementRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<ModePayementResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<ModePayementResponse> update(@RequestBody ModePayementRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
