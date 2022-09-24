package com.vms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 
  {
  	"code" : 21,
  	"centername" : "AA Center",
  	"address" : "Hyderabad Kukatpally 5098989",
  	"city" : "Hyd",
  	"state" : "Telangana",
  	"pincode" : 5098989
  
  }
  
 */


@Entity
public class VaccineCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vaccCenterId;
	private int code;
	private String centername;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vaccineCenter" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<VaccineInventory> vaccineInventories;
	
	public VaccineCenter() {
		super();
	}
	
	public VaccineCenter(int vaccCenterId) {
		this.vaccCenterId=vaccCenterId;
	}
	public int getVaccCenterId() {
		return vaccCenterId;
	}

	public void setVaccCenterId(int vaccCenterId) {
		this.vaccCenterId = vaccCenterId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCentername() {
		return centername;
	}

	public void setCentername(String centername) {
		this.centername = centername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<VaccineInventory> getVaccineInventories() {
		return vaccineInventories;
	}

	public void setVaccineInventories(List<VaccineInventory> vaccineInventories) {
		this.vaccineInventories = vaccineInventories;
	}

}
