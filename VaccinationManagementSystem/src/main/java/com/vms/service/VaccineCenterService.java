package com.vms.service;

import java.util.List;

import com.vms.entity.Member;
import com.vms.entity.VaccineCenter;
import com.vms.exception.RecordNotFound;

public interface VaccineCenterService {
	
	public VaccineCenter addVaccineCenter(VaccineCenter vaccineCenter) throws RecordNotFound;
	public VaccineCenter updateVaccineCenter(VaccineCenter vaccineCenter) throws RecordNotFound;
	public void deleteVaccineCenter(int centerId) throws RecordNotFound;
	public VaccineCenter getVaccineCenterById(int centerId) throws RecordNotFound;
	public List<VaccineCenter> getVaccineCenterByPincode(String pincode);
	public List<VaccineCenter> getVaccineCenterByCity(String city);
	public List<VaccineCenter> getAllVaccineCenters();


}
