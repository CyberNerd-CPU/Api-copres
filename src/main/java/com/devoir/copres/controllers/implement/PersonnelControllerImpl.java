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

import com.devoir.copres.controllers.PersonnelController;
import com.devoir.copres.dtoRequest.PersonnelRequest;
import com.devoir.copres.dtoResponse.PersonnelResponse;
import com.devoir.copres.service.PersonnelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/Personnel")
public class PersonnelControllerImpl implements PersonnelController {
	
PersonnelService service;
	
	

	public PersonnelControllerImpl(PersonnelService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<PersonnelResponse> save(@RequestBody PersonnelRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<PersonnelResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<PersonnelResponse> update(@RequestBody PersonnelRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
