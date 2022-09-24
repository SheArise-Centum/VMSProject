package com.vms.service;

import com.vms.entity.Member;
import com.vms.exception.RecordNotFound;

public interface MemberService {
	
	public Member addMember(Member member);
	public Member updateMember(int id,Member member) throws RecordNotFound;
	public void deleteMember(int id) throws RecordNotFound;
	public Member getMemberById(String cardId) throws RecordNotFound;
	public Member getMemberByAadhar(String aadharNo) throws RecordNotFound;
	public Member getMemberByPan(String panNo) throws RecordNotFound;


}
