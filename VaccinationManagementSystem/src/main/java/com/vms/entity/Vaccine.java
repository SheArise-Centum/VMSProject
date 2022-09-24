package com.vms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccId;
	private String vaccinename;
	private String description;	

	public Vaccine() {
		super();
	}

	public Vaccine(int vaccId) {
		this.vaccId = vaccId;
	}

	public int getVaccId() {
		return vaccId;
	}

	public void setVaccId(int vaccId) {
		this.vaccId = vaccId;
	}

	public String getVaccinename() {
		return vaccinename;
	}

	public void setVaccinename(String vaccinename) {
		this.vaccinename = vaccinename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Vaccine [vaccId=" + vaccId + ", vaccinename=" + vaccinename + ", description=" + description + "]";
	}

	
}
