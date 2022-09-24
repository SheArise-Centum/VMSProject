package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Member;
import com.vms.entity.VaccineCenter;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.VaccinationCenterRepository;

@Service("VaccineCenterService")
public class VaccineCenterServiceImpl implements VaccineCenterService {
	
	@Autowired
	VaccinationCenterRepository vaccinationCenterRepository;

	@Override
	public VaccineCenter addVaccineCenter(VaccineCenter vaccineCenter) throws RecordNotFound {
		vaccinationCenterRepository.saveAndFlush(vaccineCenter);
		return vaccineCenter;
	}

	@Override
	public VaccineCenter updateVaccineCenter(VaccineCenter vaccineCenter) throws RecordNotFound {
		VaccineCenter  bean = null;
		try {
			bean = vaccinationCenterRepository.findById(vaccineCenter.getVaccCenterId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine Center details not found!");
		}
		vaccinationCenterRepository.saveAndFlush(vaccineCenter);
		return vaccineCenter;
	}

	@Override
	public void deleteVaccineCenter(int centerid) throws RecordNotFound {
		vaccinationCenterRepository.deleteById(centerid);
	}

	@Override
	public VaccineCenter getVaccineCenterById(int centerId) throws RecordNotFound {
		VaccineCenter  bean = null;
		try {
			bean = vaccinationCenterRepository.findById(centerId).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine Center details not found!");
		}
		return bean;
	}

	@Override
	public List<VaccineCenter> getAllVaccineCenters() {
		return vaccinationCenterRepository.findAll();
	}
	
	@Override
	public List<VaccineCenter> getVaccineCenterByPincode(String pincode) {
		return vaccinationCenterRepository.findByPincode(pincode);
	}
	
	@Override
	public List<VaccineCenter> getVaccineCenterByCity(String city) {
		return vaccinationCenterRepository.findByCity(city);
	}

}
