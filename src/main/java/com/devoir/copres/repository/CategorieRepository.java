package com.devoir.copres.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {
	
	public Optional<Categorie> findByTrackingId(UUID trackingId);

	public Collection<Categorie> findAllByOrderByIdDesc();

}
