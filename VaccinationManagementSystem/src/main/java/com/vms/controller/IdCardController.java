package com.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.entity.IdCard;
import com.vms.exception.RecordNotFound;
import com.vms.service.IdCardService;

@CrossOrigin
@RestController
@RequestMapping("/vms-idcard")
public class IdCardController {
	
	@Autowired
	IdCardService idCardService;
	
	@PostMapping
	public IdCard addIdCard(@RequestBody IdCard idCard) throws RecordNotFound{
		return idCardService.addIdCard(idCard);
	}
	
	@GetMapping("/getIdByPan/{panNo}")
	public IdCard getIdByPan(@PathVariable String panNo) throws RecordNotFound{
		return idCardService.getIdByPan(panNo);
	}
	
	@GetMapping("/getIdByAadhar/{aadharNo}")
	public IdCard getIdByAadhar(@PathVariable String aadharNo) throws RecordNotFound{
		return idCardService.getIdByAadhar(aadharNo);
	}
	
	@GetMapping
	public List<IdCard> getAllIdcards() throws RecordNotFound{
		return idCardService.getAllCards();
	}

}
