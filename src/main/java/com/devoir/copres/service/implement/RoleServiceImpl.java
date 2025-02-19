package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.RoleRequest;
import com.devoir.copres.dtoResponse.RoleResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.RoleMapper;
import com.devoir.copres.model.Role;
import com.devoir.copres.repository.RoleRepository;
import com.devoir.copres.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private final RoleRepository repository;
	private final RoleMapper mapper;
	
	

	public RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public RoleResponse save(RoleRequest request) {
		Role entity = mapper.toEntity(request);
		RoleResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<RoleResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public RoleResponse update(RoleRequest request, UUID trackingId) {
		
		Role entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Role avec cet identifiant n'existe pas"));
		
		entity.setLibelle(request.libelle());
		entity.setCode(request.code());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Role entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Role avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
