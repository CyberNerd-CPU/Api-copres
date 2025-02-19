package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.ProformatCiment;
@Repository
public interface ProformatCimentRepository extends JpaRepository<ProformatCiment,Long> {
	
	public Optional<ProformatCiment> findByTrackingId(UUID trackingId);

	public List<ProformatCiment> findAllByOrderByIdDesc();

}
