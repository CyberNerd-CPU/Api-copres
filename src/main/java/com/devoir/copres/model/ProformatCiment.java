package com.devoir.copres.model;

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
public class ProformatCiment extends Base {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID trackingId;
	@ManyToOne
	@JoinColumn(name="ciment_id")
	private Ciment ciment;
	
	@ManyToOne
	@JoinColumn(name="proformat_id")
	private Proformat proformat;

	
	
	public Ciment getCiment() {
		return ciment;
	}

	public void setCiment(Ciment ciment) {
		this.ciment = ciment;
	}

	public Proformat getProformat() {
		return proformat;
	}

	public void setProformat(Proformat proformat) {
		this.proformat = proformat;
	}

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
	
	
	
	
	

}
