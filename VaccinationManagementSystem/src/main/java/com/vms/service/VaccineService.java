package com.vms.service;

import java.util.List;

import com.vms.entity.Vaccine;
import com.vms.exception.RecordNotFound;

public interface VaccineService {
	
	public Vaccine addVaccine(Vaccine vaccine) throws RecordNotFound;
	public Vaccine updateVaccine(Vaccine vaccine) throws RecordNotFound;
	public void deleteVaccine(int id) throws RecordNotFound;
	public List<Vaccine> getAllVaccines() throws RecordNotFound;
	public Vaccine getVaccineById(String vaccineName) throws RecordNotFound;

}
