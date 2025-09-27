package com.fruitnut.mca.services;



import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fruitnut.mca.entities.Game;
import com.fruitnut.mca.repository.GameRepository;

//import com.m_v_puneeth.puni_gaming_club.entities.Game;
//import com.m_v_puneeth.puni_gaming_club.repository.GameRepository;
@Service
public class GameService {
	
@Autowired
	private GameRepository gameRepository;
	

public Game saveGame(Game game) {
	return gameRepository.save(game);
}
public List<Game> getAllGames(){
	return gameRepository.findAll();
}
public boolean deleteGame(int id) {
	Optional<Game> existingGame = gameRepository.findById(id);
	if(existingGame.isPresent() ) {
		gameRepository.deleteById(id);
		return true;
	}
	return false;
}
public Game updateGame(int id,Game game) {
	Optional<Game> existingGame = gameRepository.findById(id);
	if(existingGame.isPresent()) {
		Game oldGame = existingGame.get();	
		oldGame.setName(game.getName());
		oldGame.setDescription(game.getDescription());
		oldGame.setAmount(game.getAmount());
		oldGame.setStatus(game.getStatus());
		return gameRepository.save(oldGame);
		}
	return null;
}
}