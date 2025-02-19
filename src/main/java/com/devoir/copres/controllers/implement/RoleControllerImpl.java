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

import com.devoir.copres.controllers.RoleController;
import com.devoir.copres.dtoRequest.RoleRequest;
import com.devoir.copres.dtoResponse.RoleResponse;
import com.devoir.copres.service.RoleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/role")
public class RoleControllerImpl implements RoleController {
	
RoleService service;
	
	

	public RoleControllerImpl(RoleService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<RoleResponse> save(@RequestBody RoleRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<RoleResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<RoleResponse> update(@RequestBody RoleRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
