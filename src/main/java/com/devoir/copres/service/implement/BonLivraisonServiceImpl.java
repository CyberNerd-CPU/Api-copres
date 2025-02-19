package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.BonLivraisonRequest;
import com.devoir.copres.dtoResponse.BonLivraisonResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.BonLivraisonMapper;
import com.devoir.copres.model.BonLivraison;
import com.devoir.copres.repository.BonLivraisonRepository;
import com.devoir.copres.service.BonLivraisonService;


@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {
	

	private final BonLivraisonRepository repository;
	private final BonLivraisonMapper mapper;
	
	

	public BonLivraisonServiceImpl(BonLivraisonRepository repository, BonLivraisonMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public BonLivraisonResponse save(BonLivraisonRequest request) {
		BonLivraison entity = mapper.toEntity(request);
		BonLivraisonResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<BonLivraisonResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public BonLivraisonResponse update(BonLivraisonRequest request, UUID trackingId) {
		
		BonLivraison entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le BonLivraison avec cet identifiant n'existe pas"));
		
		entity.setNumeroBon(request.numeroBon());
		entity.setDateLivraison(request.dateLivraison());
		entity.setStatut(request.statut());
		entity.setAdresseLivraison(request.adresseLivraison());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		BonLivraison entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le BonLivraison avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}
	
	

}
