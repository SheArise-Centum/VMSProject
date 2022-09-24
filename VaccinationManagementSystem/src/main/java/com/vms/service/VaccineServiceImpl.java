package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Vaccine;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.VaccineRepository;

@Service("VaccineService")
public class VaccineServiceImpl implements VaccineService {
	
	@Autowired
	VaccineRepository vaccineRepository;

	@Override
	public Vaccine addVaccine(Vaccine vaccine) throws RecordNotFound {
		vaccineRepository.saveAndFlush(vaccine);
		return vaccine;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine) throws RecordNotFound {
		Vaccine  bean = null;
		try {
			bean = vaccineRepository.findById(vaccine.getVaccId()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine details not found!");
		}
		vaccineRepository.saveAndFlush(vaccine);
		return vaccine;
	}

	@Override
	public void deleteVaccine(int id) throws RecordNotFound {
		vaccineRepository.deleteById(id);
	}

	@Override
	public List<Vaccine> getAllVaccines() throws RecordNotFound {
		return vaccineRepository.findAll();
	}

	@Override
	public Vaccine getVaccineById(String vaccineName) throws RecordNotFound {
		Vaccine  bean = null;
		try {
			for(Vaccine i : vaccineRepository.findAll()) {
				if(i.getVaccinename().equals(vaccineName)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Vaccine details not found!");
		}
		return bean;
	}

}
