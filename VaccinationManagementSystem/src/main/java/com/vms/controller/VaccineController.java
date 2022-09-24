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

import com.vms.entity.Vaccine;
import com.vms.exception.RecordNotFound;
import com.vms.service.VaccineService;


@CrossOrigin
@RestController
@RequestMapping("/vms-vaccine")
public class VaccineController {
	
	@Autowired
	VaccineService vaccineService;

	@PostMapping
	public Vaccine addVaccine(@RequestBody Vaccine vaccine) throws RecordNotFound{
		return vaccineService.addVaccine(vaccine);
	}
	
	@PutMapping("{id}")
	public Vaccine updateVaccine(@PathVariable("id") int id, @RequestBody Vaccine vaccine) throws RecordNotFound{
		return vaccineService.updateVaccine(vaccine);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteVaccine(@PathVariable("id") int id) throws RecordNotFound{
		vaccineService.deleteVaccine(id);
		return ResponseEntity.ok("Vaccine deleted successfully");
	}
	
	@GetMapping
	public List<Vaccine> getAllVaccines() throws RecordNotFound{
		return vaccineService.getAllVaccines();
	}
	
	@GetMapping("/getVaccineById/{vaccineName}")
	public Vaccine getVaccineById(@PathVariable String vaccineName) throws RecordNotFound{
		return vaccineService.getVaccineById(vaccineName);
	}
}
