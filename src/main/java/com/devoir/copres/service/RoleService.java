package com.devoir.copres.service;

import java.util.List;
import java.util.UUID;

import com.devoir.copres.dtoRequest.RoleRequest;
import com.devoir.copres.dtoResponse.RoleResponse;

public interface RoleService {
	
	public RoleResponse save(RoleRequest request);
	
	public List<RoleResponse> getAll();
	
	public RoleResponse update(RoleRequest request,UUID trackingId);
	
	public void delete(UUID trackingId);

}
