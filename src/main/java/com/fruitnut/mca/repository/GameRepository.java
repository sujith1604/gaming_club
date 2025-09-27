package com.fruitnut.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruitnut.mca.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
}