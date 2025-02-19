package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.ClientRequest;
import com.devoir.copres.dtoResponse.ClientResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.ClientMapper;
import com.devoir.copres.model.Client;
import com.devoir.copres.repository.ClientRepository;
import com.devoir.copres.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository repository;
	private final ClientMapper mapper;
	
	

	public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public ClientResponse save(ClientRequest request) {
		Client entity = mapper.toEntity(request);
		ClientResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<ClientResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ClientResponse update(ClientRequest request, UUID trackingId) {
		
		Client entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Client avec cet identifiant n'existe pas"));
		
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Client entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Client avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
