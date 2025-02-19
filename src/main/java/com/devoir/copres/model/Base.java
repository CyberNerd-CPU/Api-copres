package com.devoir.copres.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base implements Serializable {
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDate createDate;
	
	@LastModifiedDate
	private LocalDate pdateDate;
	
	@CreatedBy
	@Column(updatable=false)
	private String createBy;
	
	@LastModifiedBy
	private String modifiedBy;

	
	
	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getPdateDate() {
		return pdateDate;
	}

	public void setPdateDate(LocalDate pdateDate) {
		this.pdateDate = pdateDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
	

}
