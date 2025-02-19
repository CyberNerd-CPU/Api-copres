package com.devoir.copres.controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devoir.copres.dtoRequest.DtoGenericRequest;
import com.devoir.copres.dtoResponse.DtoGenericResponse;
import com.devoir.copres.mappers.GenericMapper;

public interface ServiceGeneric<Entity,Pk> {
	
	public JpaRepository<Entity,Pk> getDao();
	
	public DtoGenericResponse getResponse();
	
	public DtoGenericRequest getRequest();
	
	public GenericMapper getMapper();
	
	public Entity save(Entity entity);


    public void deleteById(Pk id);

    public void delete(Entity entity);
    

    public Entity update(Entity entity) ;
	
	

}
