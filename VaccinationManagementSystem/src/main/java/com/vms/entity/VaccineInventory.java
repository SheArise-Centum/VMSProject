package com.vms.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccInveId;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "vacc_center_id", referencedColumnName = "vaccCenterId")
	private VaccineCenter vaccineCenter;
	
	@OneToMany(mappedBy = "vaccineInventory" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
    private List<VaccineCount> vaccinesCount;
	
	@Transient
	private int centerid;

	public VaccineInventory() {
		super();
	}
	

	public int getCenterid() {
		return centerid;
	}


	public void setCenterid(int centerid) {
		this.centerid = centerid;
	}


	public int getVaccInveId() {
		return vaccInveId;
	}

	public void setVaccInveId(int vaccInveId) {
		this.vaccInveId = vaccInveId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<VaccineCount> getVaccinesCount() {
		return vaccinesCount;
	}

	public void setVaccinesCount(List<VaccineCount> vaccinesCount) {
		this.vaccinesCount = vaccinesCount;
	}

	public VaccineCenter getVaccineCenter() {
		return vaccineCenter;
	}

	public void setVaccineCenter(VaccineCenter vaccineCenter) {
		this.vaccineCenter = vaccineCenter;
	}

	@Override
	public String toString() {
		return "VaccineInventory [vaccInveId=" + vaccInveId + ", date=" + date + ", vaccineCenter=" + vaccineCenter
				+ ", vaccinesCount=" + vaccinesCount + "]";
	}

	
}
