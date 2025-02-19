package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.ModePayementRequest;
import com.devoir.copres.dtoResponse.ModePayementResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.ModePayementMapper;
import com.devoir.copres.model.ModePayement;
import com.devoir.copres.repository.ModePayementRepository;
import com.devoir.copres.service.ModePayementService;

@Service
public class ModePayementServiceImpl implements ModePayementService {
	
	private final ModePayementRepository repository;
	private final ModePayementMapper mapper;
	
	

	public ModePayementServiceImpl(ModePayementRepository repository, ModePayementMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public ModePayementResponse save(ModePayementRequest request) {
		ModePayement entity = mapper.toEntity(request);
		ModePayementResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<ModePayementResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ModePayementResponse update(ModePayementRequest request, UUID trackingId) {
		
		ModePayement entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le ModePayement avec cet identifiant n'existe pas"));
		
		entity.setLibelle(request.libelle());
		entity.setDescription(request.description());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		ModePayement entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le ModePayement avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
