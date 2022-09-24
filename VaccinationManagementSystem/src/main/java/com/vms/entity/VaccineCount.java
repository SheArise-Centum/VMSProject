package com.vms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccineCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccCountId;
	private int quantity;
	private double price;
	
	@OneToOne
	@JoinColumn(name = "vaccineId")
	private Vaccine vaccine;
	
	//@JsonIgnore
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "vacc_inve_id", referencedColumnName = "vaccInveId")
	private VaccineInventory vaccineInventory;
	
	public VaccineCount() {
		super();
	}
	
	public VaccineInventory getVaccineInventory() {
		return vaccineInventory;
	}


	public void setVaccineInventory(VaccineInventory vaccineInventory) {
		this.vaccineInventory = vaccineInventory;
	}


	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public int getVaccCountId() {
		return vaccCountId;
	}

	public void setVaccCountId(int vaccCountId) {
		this.vaccCountId = vaccCountId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VaccineCount [vaccCountId=" + vaccCountId + ", quantity=" + quantity + ", price=" + price + ", vaccine="
				+ vaccine + "]";
	}
	

}
