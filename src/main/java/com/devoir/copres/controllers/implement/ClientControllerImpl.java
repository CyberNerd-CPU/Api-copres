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

import com.devoir.copres.controllers.ClientController;
import com.devoir.copres.dtoRequest.ClientRequest;
import com.devoir.copres.dtoResponse.ClientResponse;
import com.devoir.copres.service.ClientService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/client")
public class ClientControllerImpl implements ClientController {
	
ClientService service;
	
	

	public ClientControllerImpl(ClientService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<ClientResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<ClientResponse> update(@RequestBody ClientRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
