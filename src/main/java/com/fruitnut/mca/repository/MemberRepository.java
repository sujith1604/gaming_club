package com.fruitnut.mca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fruitnut.mca.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
Member findMemberByPhone(String phone);
}