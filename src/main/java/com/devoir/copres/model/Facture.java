package com.devoir.copres.model;


import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Facture extends Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID trackingId;
	private LocalDate echeance_date;
	private Double montantTotal;
	private Double montantPayer;
	
	@ManyToOne
	@JoinColumn(name="proformat_id")
	private Proformat proformat;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public LocalDate getEcheance_date() {
		return echeance_date;
	}

	public void setEcheance_date(LocalDate echeance_date) {
		this.echeance_date = echeance_date;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public Double getMontantPayer() {
		return montantPayer;
	}

	public void setMontantPayer(Double montantPayer) {
		this.montantPayer = montantPayer;
	}

	public Proformat getProformat() {
		return proformat;
	}

	public void setProformat(Proformat proformat) {
		this.proformat = proformat;
	}
	
	
	

}
