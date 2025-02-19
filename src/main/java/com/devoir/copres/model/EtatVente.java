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
public class EtatVente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID trackingId;
	private Double montantTotal;
	private Double nombreVente;
	private LocalDate dateBebut;
	private LocalDate dateFin;
	
	
	@ManyToOne
	@JoinColumn(name="commerciale_id")
	private Commerciale commerciale;
	
	@ManyToOne
	@JoinColumn(name="facture_id")
	private Facture facture;
	
	
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
	public Double getNombreVente() {
		return nombreVente;
	}
	public void setNombreVente(Double nombreVente) {
		this.nombreVente = nombreVente;
	}
	public LocalDate getDateBebut() {
		return dateBebut;
	}
	public void setDateBebut(LocalDate dateBebut) {
		this.dateBebut = dateBebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public Commerciale getCommerciale() {
		return commerciale;
	}
	public void setCommerciale(Commerciale commerciale) {
		this.commerciale = commerciale;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	
	
	
	
	

}
