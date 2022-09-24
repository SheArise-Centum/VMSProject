package com.vms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memId;
	private  boolean dose1;
	private boolean dose2;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dose1date;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dose2date;
	
	@OneToOne
	@JoinColumn(name = "card_id", referencedColumnName = "cardId")
	private IdCard idCard;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "vac_reg_id", referencedColumnName = "regId")
    private VaccineRegistration vaccineRegistration;
	
	@Transient
	private int regId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "member" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Appointment> appointments;

	public Member() {
		super();
	}
	
	public Member(int memId) {
		this.memId=memId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public boolean isDose1() {
		return dose1;
	}

	public void setDose1(boolean dose1) {
		this.dose1 = dose1;
	}

	public boolean isDose2() {
		return dose2;
	}

	public void setDose2(boolean dose2) {
		this.dose2 = dose2;
	}

	public LocalDate getDose1date() {
		return dose1date;
	}

	public void setDose1date(LocalDate dose1date) {
		this.dose1date = dose1date;
	}

	public LocalDate getDose2date() {
		return dose2date;
	}

	public void setDose2date(LocalDate dose2date) {
		this.dose2date = dose2date;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public VaccineRegistration getVaccineRegistration() {
		return vaccineRegistration;
	}

	public void setVaccineRegistration(VaccineRegistration vaccineRegistration) {
		this.vaccineRegistration = vaccineRegistration;
	}
	
	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", dose1=" + dose1 + ", dose2=" + dose2 + ", dose1date=" + dose1date
				+ ", dose2date=" + dose2date + ", idCard=" + idCard + ", vaccineRegistration=" + vaccineRegistration
				+ ", appointments=" + appointments + "]";
	}

	

}
