package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Commerciale;
@Repository
public interface CommercialeRepository extends JpaRepository<Commerciale,Long> {
	
	public Optional<Commerciale> findByTrackingId(UUID trackingId);

	public List<Commerciale> findAllByOrderByIdDesc();

}
