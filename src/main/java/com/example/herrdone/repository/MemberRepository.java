package com.example.herrdone.repository;

import com.example.herrdone.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
//    @Query("select m from Member m where m.email = :email")
    Optional<Member> findByEmail(String email);
    Boolean existsMemberByEmail(String email);

    Long deleteMemberByEmail(String email);
}
