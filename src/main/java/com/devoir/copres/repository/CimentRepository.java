package com.devoir.copres.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Ciment;
@Repository
public interface CimentRepository extends JpaRepository<Ciment,Long> {
	
	public Optional<Ciment> findByTrackingId(UUID trackingId);

	public List<Ciment> findAllByOrderByIdDesc();

}
