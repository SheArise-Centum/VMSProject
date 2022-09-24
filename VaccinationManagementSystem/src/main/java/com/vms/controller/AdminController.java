package com.vms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.dto.LoginDTO;
import com.vms.entity.Admin;
import com.vms.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/vms-admin")
public class AdminController {
	
	@Autowired private AdminService aservice;
	
	@PostMapping("validate")
	public ResponseEntity<?> validate(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Admin admin=aservice.validate(dto);
		if(admin==null)
			return ResponseEntity.badRequest().body("Incorrect userid or password");
		return ResponseEntity.ok(admin);
	}

}
