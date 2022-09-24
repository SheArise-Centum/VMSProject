package com.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.Appointment;
import com.vms.entity.IdCard;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard,Integer>{ 
	IdCard findByPanNo(String pan);
	IdCard findByAadharNo(String aadhar);
}

