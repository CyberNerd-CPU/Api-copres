package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Personnel;
@Repository
public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
	
	public Optional<Personnel> findByTrackingId(UUID trackingId);

	public List<Personnel> findAllByOrderByIdDesc();

}
