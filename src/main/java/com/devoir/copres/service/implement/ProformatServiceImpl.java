package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.ProformatRequest;
import com.devoir.copres.dtoResponse.ProformatResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.ProformatMapper;
import com.devoir.copres.model.Proformat;
import com.devoir.copres.repository.ClientRepository;
import com.devoir.copres.repository.ProformatRepository;
import com.devoir.copres.service.ProformatService;


@Service
public class ProformatServiceImpl implements ProformatService {
	
	private final ProformatRepository repository;
	private final ProformatMapper mapper;
	private final ClientRepository clientRepo;
	
	

	public ProformatServiceImpl(ProformatRepository repository, ProformatMapper mapper, ClientRepository clientRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.clientRepo = clientRepo;
	}
	
	@Transactional
	@Override
	public ProformatResponse save(ProformatRequest request) {
		Proformat entity = mapper.toEntity(request);
		ProformatResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<ProformatResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ProformatResponse update(ProformatRequest request, UUID trackingId) {
		
		Proformat entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Proformat avec cet identifiant n'existe pas"));
		
entity.setMontantTotal(request.montantTotal());
		
		entity.setStatut(request.statut());
		
		entity.setClient(clientRepo.findByTrackingId(request.clientId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Proformat entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Proformat avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
