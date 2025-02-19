package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.ModePayement;
@Repository
public interface ModePayementRepository extends JpaRepository<ModePayement,Long> {
	
	public Optional<ModePayement> findByTrackingId(UUID trackingId);

	public List<ModePayement> findAllByOrderByIdDesc();

}
