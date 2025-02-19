package com.devoir.copres.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Proformat;
@Repository
public interface ProformatRepository extends JpaRepository<Proformat,Long> {
	
	public Optional<Proformat> findByTrackingId(UUID trackingId);

	public List<Proformat> findAllByOrderByIdDesc();

}
