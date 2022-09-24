package com.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.VaccineCenter;
import com.vms.exception.RecordNotFound;
import com.vms.service.VaccineCenterService;

@CrossOrigin
@RestController
@RequestMapping("/vms-vaccinecenter")
public class VaccineCenterController {
	
	@Autowired
	VaccineCenterService vaccineCenterService;
	
	@PostMapping
	public VaccineCenter addVaccineCenter(@RequestBody VaccineCenter vaccineCenter) throws RecordNotFound{
		return vaccineCenterService.addVaccineCenter(vaccineCenter);
	}
	
	@PutMapping("{id}")
	public VaccineCenter updateVaccineCenter(@PathVariable("id") int id, @RequestBody VaccineCenter vaccineCenter) throws RecordNotFound{
		return vaccineCenterService.updateVaccineCenter(vaccineCenter);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteVaccineCenter(@PathVariable("id") int id) throws RecordNotFound{
		vaccineCenterService.deleteVaccineCenter(id);
		return ResponseEntity.ok("Deleted successfully");
	}
	
	@GetMapping("/getVaccineCenterById/{centerId}")
	public VaccineCenter getVaccineCenterById(@PathVariable int centerId) throws RecordNotFound{
		return vaccineCenterService.getVaccineCenterById(centerId);
	}
	
	@GetMapping("/getVaccineCenterByPinCode/{pinCode}")
	public List<VaccineCenter> getVaccineCenterByPincode(@PathVariable String pinCode) throws RecordNotFound{
		return vaccineCenterService.getVaccineCenterByPincode(pinCode);
	}
	
	@GetMapping("/getVaccineCenterByCity/{city}")
	public List<VaccineCenter> getVaccineCenterByCity(@PathVariable String city) throws RecordNotFound{
		return vaccineCenterService.getVaccineCenterByCity(city);
	}
	
	@GetMapping
	public List<VaccineCenter> getAllVaccineCenters() throws RecordNotFound{
		return vaccineCenterService.getAllVaccineCenters();
	}


}










