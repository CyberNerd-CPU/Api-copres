package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.ReglementRequest;
import com.devoir.copres.dtoResponse.ReglementResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.ReglementMapper;
import com.devoir.copres.model.Reglement;
import com.devoir.copres.repository.FactureRepository;
import com.devoir.copres.repository.ModePayementRepository;
import com.devoir.copres.repository.ReglementRepository;
import com.devoir.copres.service.ReglementService;

@Service
public class ReglementServiceImpl implements ReglementService {
	
	private final ReglementRepository repository;
	private final ReglementMapper mapper;
	private final FactureRepository factureRepo;
	private final ModePayementRepository modePayementRepo;
	
	

	public ReglementServiceImpl(ReglementRepository repository, ReglementMapper mapper, ModePayementRepository modePayementRepo, FactureRepository factureRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.factureRepo = factureRepo;
		this.modePayementRepo = modePayementRepo;
	}
	
	@Transactional
	@Override
	public ReglementResponse save(ReglementRequest request) {
		Reglement entity = mapper.toEntity(request);
		ReglementResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<ReglementResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public ReglementResponse update(ReglementRequest request, UUID trackingId) {
		
		Reglement entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Reglement avec cet identifiant n'existe pas"));
		
		entity.setMontantTotal(request.montantTotal());
		
		entity.setDateReglement(request.dateReglement());
		
		entity.setFacture(factureRepo.findByTrackingId(request.factureId()).get());
		entity.setModePayement(modePayementRepo.findByTrackingId(request.modePayementId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Reglement entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Reglement avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
