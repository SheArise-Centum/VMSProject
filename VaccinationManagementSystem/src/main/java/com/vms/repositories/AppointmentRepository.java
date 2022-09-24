package com.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{ 
	
	

}

//Data Access Layer