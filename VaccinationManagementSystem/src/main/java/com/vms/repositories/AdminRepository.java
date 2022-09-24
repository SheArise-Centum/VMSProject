package com.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

}
