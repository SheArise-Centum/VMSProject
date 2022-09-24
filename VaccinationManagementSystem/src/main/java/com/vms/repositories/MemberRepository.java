package com.vms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vms.entity.IdCard;
import com.vms.entity.Member;

@Repository
public interface MemberRepository  extends JpaRepository< Member,Integer>{ 

}
