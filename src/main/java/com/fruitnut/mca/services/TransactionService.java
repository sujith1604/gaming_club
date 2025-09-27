package com.fruitnut.mca.services;



import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitnut.mca.Dtos.PlayGameDto;
import com.fruitnut.mca.entities.Game;
import com.fruitnut.mca.entities.Member;
import com.fruitnut.mca.entities.Transaction;
import com.fruitnut.mca.repository.GameRepository;
import com.fruitnut.mca.repository.MemberRepository;
import com.fruitnut.mca.repository.TransactionRepository;

@Service
public class TransactionService {
@Autowired TransactionRepository transactionRepository;
@Autowired MemberRepository memberRepository;
@Autowired GameRepository gameRepository;

public Transaction playGame(PlayGameDto gameDto) {
	Member member = memberRepository.findById(gameDto.getMember_id()).get();
	Game game = gameRepository.findById(gameDto.getGame_id()).get();
	Transaction transaction = new Transaction();
	transaction.setMember(member);
	transaction.setGame(game);
	transaction.setAmount(game.getAmount());
	transaction.setDate(LocalDateTime.now());
	transactionRepository.save(transaction);
	
	member.setBalance(member.getBalance() - game.getAmount());
	memberRepository.save(member);
	
	return transaction;
	
}
}