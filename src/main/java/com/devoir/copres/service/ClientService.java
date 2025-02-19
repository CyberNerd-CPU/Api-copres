package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.ClientRequest;
import com.devoir.copres.dtoResponse.ClientResponse;

public interface ClientService {
	
	public ClientResponse save(ClientRequest request);
	
	public List<ClientResponse> getAll();
	
	public ClientResponse update(ClientRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
