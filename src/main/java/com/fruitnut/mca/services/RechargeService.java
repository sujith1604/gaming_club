package com.fruitnut.mca.services;




import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitnut.mca.Dtos.DoRechargeDto;
import com.fruitnut.mca.entities.Collection;
import com.fruitnut.mca.entities.Member;
import com.fruitnut.mca.entities.Recharge;
import com.fruitnut.mca.repository.CollectionRepository;
import com.fruitnut.mca.repository.MemberRepository;
import com.fruitnut.mca.repository.RechargeRepository;

//import com.m_v_puneeth.puni_gaming_club.entities.Recharge;
//import com.m_v_puneeth.puni_gaming_club.repository.RechargeRepository;
//
@Service
public class RechargeService {
	@Autowired private RechargeRepository rechargeRepository;
	@Autowired private MemberRepository memberRepository;
	@Autowired private CollectionRepository collectionRepository;
	
	public Recharge doRecharge(DoRechargeDto rechargeDto) {
		Member member =  memberRepository.findById(rechargeDto.getMember_id()).get();
		Recharge recharge = new Recharge();
		recharge.setMember(member);
		recharge.setDate_Time(LocalDateTime.now());
		recharge.setAmount(rechargeDto.getAmount());
		rechargeRepository.save(recharge);
		
		member.setBalance(rechargeDto.getAmount());
		memberRepository.save(member);
		
		Optional<Collection> collectOptional = collectionRepository.findCollectionByDate(LocalDate.now());
		if(collectOptional.isPresent())
		{
			Collection collection = new Collection();
			collection.setDate(LocalDate.now());
			collection.setAmount(rechargeDto.getAmount());
			collectionRepository.save(collection);
		}
		else
		{
			Collection collection = new Collection();
			collection.setDate(LocalDate.now());
			collection.setAmount(rechargeDto.getAmount());
			collectionRepository.save(collection);

			
		}
			
		
		return recharge;
		
		
	}

}