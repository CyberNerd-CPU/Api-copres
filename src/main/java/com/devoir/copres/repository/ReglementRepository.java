package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Reglement;
@Repository
public interface ReglementRepository extends JpaRepository<Reglement,Long> {
	
	public Optional<Reglement> findByTrackingId(UUID trackingId);

	public List<Reglement> findAllByOrderByIdDesc();

}
