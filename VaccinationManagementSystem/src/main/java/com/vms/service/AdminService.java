package com.vms.service;

import com.vms.dto.LoginDTO;
import com.vms.entity.Admin;

public interface AdminService {
	Admin validate(LoginDTO dto);
	void register(Admin admin);
	
}
