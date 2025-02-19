package com.devoir.copres.service.implement;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devoir.copres.dtoRequest.PersonnelRequest;
import com.devoir.copres.dtoResponse.PersonnelResponse;
import jakarta.transaction.Transactional;
import com.devoir.copres.mappers.PersonnelMapper;
import com.devoir.copres.model.Personnel;
import com.devoir.copres.repository.PersonnelRepository;
import com.devoir.copres.service.PersonnelService;

@Service
public class PersonnelServiceImpl implements PersonnelService {
	
	private final PersonnelRepository repository;
	private final PersonnelMapper mapper;
	
	

	public PersonnelServiceImpl(PersonnelRepository repository, PersonnelMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Transactional
	@Override
	public PersonnelResponse save(PersonnelRequest request) {
		Personnel entity = mapper.toEntity(request);
		PersonnelResponse response = mapper.toResponse(repository.save(entity));
		return response;
	}

	@Transactional
	@Override
	public List<PersonnelResponse> getAll() {
		
		return repository.findAllByOrderByIdDesc().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public PersonnelResponse update(PersonnelRequest request, UUID trackingId) {
		
		Personnel entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Personnel avec cet identifiant n'existe pas"));
		
		entity.setNom(request.nom());
		entity.setPrenom(request.prenom());
		entity.setNumeroCni(request.numeroCni());
		entity.setAdresse(request.adresse());
		entity.setTelephone(request.telephone());
		
		
		return mapper.toResponse(entity);
	}

	@Transactional
	@Override
	public void delete(UUID trackingId) {
		Personnel entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Le Personnel avec cet identifiant n'existe pas"));
		repository.delete(entity);
		
	}

}
