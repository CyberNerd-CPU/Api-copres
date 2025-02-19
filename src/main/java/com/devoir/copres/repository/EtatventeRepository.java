package com.devoir.copres.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.EtatVente;
@Repository
public interface EtatventeRepository extends JpaRepository<EtatVente,Long> {
	
	public Optional<EtatVente> findByTrackingId(UUID trackingId);

	public List<EtatVente> findAllByOrderByIdDesc();

}
