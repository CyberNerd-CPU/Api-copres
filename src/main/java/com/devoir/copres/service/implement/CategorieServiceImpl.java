package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.CategorieRequest;
import com.devoir.copres.dtoResponse.CategorieResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.CategorieMapper;
import com.devoir.copres.model.Categorie;
import com.devoir.copres.repository.CategorieRepository;
import com.devoir.copres.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	private final CategorieRepository repository;
	private final CategorieMapper mapper;
	
	

	public CategorieServiceImpl(CategorieRepository repository, CategorieMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public CategorieResponse save(CategorieRequest request) {
		Categorie entity = mapper.toEntity(request);
		CategorieResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<CategorieResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public CategorieResponse update(CategorieRequest request, UUID trackingId) {
		
		Categorie entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Categorie avec cet identifiant n'existe pas"));
		
		entity.setLibelle(request.libelle());
		entity.setDescription(request.description());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Categorie entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Categorie avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
