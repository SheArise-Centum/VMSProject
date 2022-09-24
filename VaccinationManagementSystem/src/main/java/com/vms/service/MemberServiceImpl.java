package com.vms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vms.entity.Member;
import com.vms.exception.RecordNotFound;
import com.vms.repositories.MemberRepository;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberRepository memberRepository;

	@Override
	public Member addMember(Member member) {
		memberRepository.saveAndFlush(member);
		return member;
	}

	@Override
	public Member updateMember(int id,Member member) throws RecordNotFound {
		Member  bean = null;
		try {
			bean = memberRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Member details not found!");
		}
		member.setMemId(id);
		member.setVaccineRegistration(bean.getVaccineRegistration());
		member.setIdCard(bean.getIdCard());
		memberRepository.saveAndFlush(member);
		return member;
	}

	@Override
	public void deleteMember(int memberId) throws RecordNotFound {
		Member  bean = null;
		try {
			bean = memberRepository.findById(memberId).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Member details not found!");
		}
		memberRepository.deleteById(memberId);
	}

	@Override
	public Member getMemberById(String cardId) throws RecordNotFound {
		Member  bean = null;
		try {
			for(Member i : memberRepository.findAll()) {
				if(i.getIdCard().equals(cardId)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Member details not found!");
		}
		return bean;
	}

	@Override
	public Member getMemberByAadhar(String aadharNo) throws RecordNotFound {
		Member  bean = null;
		try {
			for(Member i : memberRepository.findAll()) {
				if(i.equals(aadharNo)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Member details not found!");
		}
		return bean;
	}

	@Override
	public Member getMemberByPan(String panNo) throws RecordNotFound {
		Member  bean = null;
		try {
			for(Member i : memberRepository.findAll()) {
				if(i.getIdCard().getPanNo().equals(panNo)) {
					bean = i;
				}
			}
		}
		catch(Exception e) {
			throw new RecordNotFound("Member details not found!");
		}
		return bean;
	}

}
