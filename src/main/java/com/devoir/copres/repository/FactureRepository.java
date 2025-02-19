package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	
	public Optional<Facture> findByTrackingId(UUID trackingId);

	public List<Facture> findAllByOrderByIdDesc();

}
