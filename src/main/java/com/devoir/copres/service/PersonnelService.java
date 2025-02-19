package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.PersonnelRequest;
import com.devoir.copres.dtoResponse.PersonnelResponse;

public interface PersonnelService {
	
	public PersonnelResponse save(PersonnelRequest request);
	
	public List<PersonnelResponse> getAll();
	
	public PersonnelResponse update(PersonnelRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
