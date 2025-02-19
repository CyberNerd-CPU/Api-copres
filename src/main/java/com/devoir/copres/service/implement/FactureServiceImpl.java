package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.FactureRequest;
import com.devoir.copres.dtoResponse.FactureResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.FactureMapper;
import com.devoir.copres.model.Facture;
import com.devoir.copres.repository.FactureRepository;
import com.devoir.copres.repository.ProformatRepository;
import com.devoir.copres.service.FactureService;

@Service
public class FactureServiceImpl implements FactureService {
	
	private final FactureRepository repository;
	private final FactureMapper mapper;
	private final ProformatRepository proformatRepo;
	
	

	public FactureServiceImpl(FactureRepository repository, FactureMapper mapper, ProformatRepository proformatRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.proformatRepo = proformatRepo;
	}
	
	@Transactional
	@Override
	public FactureResponse save(FactureRequest request) {
		Facture entity = mapper.toEntity(request);
		FactureResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<FactureResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public FactureResponse update(FactureRequest request, UUID trackingId) {
		
		Facture entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Facture avec cet identifiant n'existe pas"));
		
		entity.setMontantTotal(request.montantTotal());
		
		entity.setEcheance_date(request.echeance_date());
		entity.setMontantPayer(request.montantPayer());
		entity.setProformat(proformatRepo.findByTrackingId(request.proformatId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Facture entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Facture avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
