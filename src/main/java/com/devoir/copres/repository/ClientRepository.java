package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Client;




@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
	
	public Optional<Client> findByTrackingId(UUID trackingId);

	public List<Client> findAllByOrderByIdDesc();

}
