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
public class Reglement extends Base {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID trackingId;
	private Double montantTotal;
	private LocalDate dateReglement;
	
	@ManyToOne
	@JoinColumn(name="facture_id")
	private Facture facture;
	
	@ManyToOne
	@JoinColumn(name="modePayement_id")
	private ModePayement modePayement;

	
	
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

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public LocalDate getDateReglement() {
		return dateReglement;
	}

	public void setDateReglement(LocalDate dateReglement) {
		this.dateReglement = dateReglement;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public ModePayement getModePayement() {
		return modePayement;
	}

	public void setModePayement(ModePayement modePayement) {
		this.modePayement = modePayement;
	}
	
	
	

}
