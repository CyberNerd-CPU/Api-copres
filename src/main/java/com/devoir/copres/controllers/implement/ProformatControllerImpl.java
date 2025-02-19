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

import com.devoir.copres.controllers.ProformatController;
import com.devoir.copres.dtoRequest.ProformatRequest;
import com.devoir.copres.dtoResponse.ProformatResponse;
import com.devoir.copres.service.ProformatService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/proformat")
public class ProformatControllerImpl implements ProformatController {
	
ProformatService service;
	
	

	public ProformatControllerImpl(ProformatService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<ProformatResponse> save(@RequestBody ProformatRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<ProformatResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<ProformatResponse> update(@RequestBody ProformatRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
