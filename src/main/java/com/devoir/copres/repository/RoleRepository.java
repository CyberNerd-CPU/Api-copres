package com.devoir.copres.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devoir.copres.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	public Optional<Role> findByTrackingId(UUID trackingId);

	public List<Role> findAllByOrderByIdDesc();

}
