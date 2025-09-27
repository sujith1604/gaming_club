package com.fruitnut.mca.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruitnut.mca.Dtos.DoRechargeDto;
import com.fruitnut.mca.entities.Recharge;
import com.fruitnut.mca.services.RechargeService;



//import com.m_v_puneeth.puni_gaming_club.Dtos.DoRechargeDto;
//import com.m_v_puneeth.puni_gaming_club.entities.Recharge;
//import com.m_v_puneeth.puni_gaming_club.service.RechargeService;

@RestController
@RequestMapping("/recharge")
public class RechargeController {
@Autowired RechargeService rechargeService;

@PostMapping
public Recharge recharge(@RequestBody DoRechargeDto rechargeDto) {
	return rechargeService.doRecharge(rechargeDto);
}
}