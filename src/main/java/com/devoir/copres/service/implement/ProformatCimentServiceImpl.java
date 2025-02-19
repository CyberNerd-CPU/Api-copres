package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.ProformatCimentRequest;
import com.devoir.copres.dtoResponse.ProformatCimentResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.ProformatCimentMapper;
import com.devoir.copres.model.ProformatCiment;
import com.devoir.copres.repository.CimentRepository;
import com.devoir.copres.repository.ProformatCimentRepository;
import com.devoir.copres.repository.ProformatRepository;
import com.devoir.copres.service.ProformatCimentService;

@Service
public class ProformatCimentServiceImpl implements ProformatCimentService {
	
	private final ProformatCimentRepository repository;
	private final ProformatCimentMapper mapper;
	private final ProformatRepository proformatRepo;
	private final CimentRepository cimRepo;
	
	

	public ProformatCimentServiceImpl(ProformatCimentRepository repository, ProformatCimentMapper mapper, ProformatRepository proformatRepo, CimentRepository cimRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.proformatRepo = proformatRepo;
		this.cimRepo = cimRepo;
	}
	
	@Transactional
	@Override
	public ProformatCimentResponse save(ProformatCimentRequest request) {
		ProformatCiment entity = mapper.toEntity(request);
		ProformatCimentResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<ProformatCimentResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ProformatCimentResponse update(ProformatCimentRequest request, UUID trackingId) {
		
		ProformatCiment entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le ProformatCiment avec cet identifiant n'existe pas"));
		
		entity.setCiment(cimRepo.findByTrackingId(request.cimentId()).get());
		entity.setProformat(proformatRepo.findByTrackingId(request.proformatId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		ProformatCiment entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le ProformatCiment avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
