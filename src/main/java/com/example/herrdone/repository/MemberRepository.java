package com.example.herrdone.repository;

import com.example.herrdone.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Boolean existsMemberByEmail(String email);
}
