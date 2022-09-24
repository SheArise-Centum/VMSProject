package com.vms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.VaccineCenter;

@Repository
public interface VaccinationCenterRepository  extends JpaRepository< VaccineCenter,Integer>{ 
	List<VaccineCenter> findByPincode(String pincode);
	List<VaccineCenter> findByCity(String city);
}

