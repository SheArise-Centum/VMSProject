package com.vms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Appointment;
import com.vms.entity.IdCard;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.IdCardRepository;

@Service("IdCardService")
public class IdCardServiceImpl implements IdCardService{
	
	@Autowired
	IdCardRepository idCardRepository;

	@Override
	public IdCard addIdCard(IdCard idCard) throws RecordNotFound {
		idCardRepository.saveAndFlush(idCard);
		return idCard;
	}

	@Override
	public IdCard getIdByPan(String panNo) throws RecordNotFound {
		IdCard  bean = null;
			bean=idCardRepository.findByPanNo(panNo);
		if(bean==null)
			throw new RecordNotFound("Id Card details not found!");
		System.out.println(bean);
		return bean;
	}

	@Override
	public IdCard getIdByAadhar(String aadharNo) throws RecordNotFound {
		IdCard  bean = null;
		bean=idCardRepository.findByAadharNo(aadharNo);
		if(bean==null)
			throw new RecordNotFound("Id Card details not found!");
		return bean;
	}

	@Override
	public List<IdCard> getAllCards() {
		// TODO Auto-generated method stub
		return idCardRepository.findAll();
	}
	
	

}
