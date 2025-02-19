package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.CimentRequest;
import com.devoir.copres.dtoResponse.CimentResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.CimentMapper;
import com.devoir.copres.model.Ciment;
import com.devoir.copres.repository.CategorieRepository;
import com.devoir.copres.repository.CimentRepository;
import com.devoir.copres.service.CimentService;

@Service
public class CimentServiceImpl implements CimentService {
	
	private final CimentRepository repository;
	private final CategorieRepository catRepo;
	private final CimentMapper mapper;
	
	

	public CimentServiceImpl(CimentRepository repository, CimentMapper mapper, CategorieRepository catRepo) {
		this.repository = repository;
		this.catRepo = catRepo;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public CimentResponse save(CimentRequest request) {
		Ciment entity = mapper.toEntity(request);
		CimentResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<CimentResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CimentResponse update(CimentRequest request, UUID trackingId) {
		
		Ciment entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Ciment avec cet identifiant n'existe pas"));
		
		entity.setLibelle(request.libelle());
		entity.setPrixUnitaire(request.prixUnitaire());
		entity.setQuantite(request.quantite());
		entity.setCategorie(catRepo.findByTrackingId(request.categorieId()).get());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Ciment entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Ciment avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
