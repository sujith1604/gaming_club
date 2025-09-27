package com.fruitnut.mca.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruitnut.mca.entities.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
List<Transaction> findTransactionByMemberId(int Member_id);
}