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

import com.devoir.copres.controllers.CategorieController;
import com.devoir.copres.dtoRequest.CategorieRequest;
import com.devoir.copres.dtoResponse.CategorieResponse;
import com.devoir.copres.service.CategorieService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categorie")
public class CategorieControllerImpl implements CategorieController {
	
	CategorieService service;
	
	

	public CategorieControllerImpl(CategorieService service) {
		
		this.service = service;
	}

	@Override
	@PostMapping()
	public ResponseEntity<CategorieResponse> save(@RequestBody CategorieRequest request){
		
			return ResponseEntity.ok(service.save(request));
	};
	
	@Override
	@GetMapping("/getAll")
	public ResponseEntity<List<CategorieResponse>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		
	};
	
	@Override
	@PostMapping("/{trakingId}")
	public ResponseEntity<CategorieResponse> update(@RequestBody CategorieRequest request, @PathVariable UUID trackingId){
		
		return ResponseEntity.ok(service.update(request,trackingId));
		
	} ;
	
	@Override
	@DeleteMapping("/{trakingId}")
	public void delete(@PathVariable UUID trackingId){
		
		service.delete(trackingId);
		
	} ;

}
