package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.CommercialeRequest;
import com.devoir.copres.dtoResponse.CommercialeResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.CommercialeMapper;
import com.devoir.copres.model.Commerciale;
import com.devoir.copres.repository.CommercialeRepository;
import com.devoir.copres.service.CommercialeService;

@Service
public class CommercialeServiceImpl implements CommercialeService {
	
	private final CommercialeRepository repository;
	private final CommercialeMapper mapper;
	
	

	public CommercialeServiceImpl(CommercialeRepository repository, CommercialeMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public CommercialeResponse save(CommercialeRequest request) {
		Commerciale entity = mapper.toEntity(request);
		CommercialeResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<CommercialeResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CommercialeResponse update(CommercialeRequest request, UUID trackingId) {
		
		Commerciale entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Commerciale avec cet identifiant n'existe pas"));
		
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		entity.setMatricle(request.matricle());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Commerciale entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Commerciale avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
