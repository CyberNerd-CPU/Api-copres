package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.BonLivraison;

@Repository
public interface BonLivraisonRepository extends JpaRepository<BonLivraison,Long> {
	
	public Optional<BonLivraison> findByTrackingId(UUID trackingId);

	public List<BonLivraison> findAllByOrderByIdDesc();

}
