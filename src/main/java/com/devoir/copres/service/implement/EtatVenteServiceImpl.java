package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.EtatVenteRequest;
import com.devoir.copres.dtoResponse.EtatVenteResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.EtatVenteMapper;
import com.devoir.copres.model.EtatVente;
import com.devoir.copres.repository.CommercialeRepository;
import com.devoir.copres.repository.EtatventeRepository;
import com.devoir.copres.repository.FactureRepository;
import com.devoir.copres.service.EtatVenteService;

@Service
public class EtatVenteServiceImpl implements EtatVenteService {
	
	private final EtatventeRepository repository;
	private final EtatVenteMapper mapper;
	private final CommercialeRepository comRepo;
	private final FactureRepository facRepo;
	
	

	public EtatVenteServiceImpl(EtatventeRepository repository, EtatVenteMapper mapper, FactureRepository facRepo, CommercialeRepository comRepo) {
		this.repository = repository;
		this.mapper = mapper;
		this.comRepo = comRepo;
		this.facRepo = facRepo;
	}
	
	@Transactional
	@Override
	public EtatVenteResponse save(EtatVenteRequest request) {
		EtatVente entity = mapper.toEntity(request);
		EtatVenteResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<EtatVenteResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public EtatVenteResponse update(EtatVenteRequest request, UUID trackingId) {
		
		EtatVente entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le EtatVente avec cet identifiant n'existe pas"));
		
		entity.setMontantTotal(request.montantTotal());
		entity.setDateBebut(request.dateBebut());
		entity.setDateFin(request.dateFin());
		entity.setNombreVente(request.nombreVente());
		entity.setCommerciale(comRepo.findByTrackingId(request.commercialeId()).get());
		entity.setFacture(facRepo.findByTrackingId(request.factureId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		EtatVente entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("L'etat de vente avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
