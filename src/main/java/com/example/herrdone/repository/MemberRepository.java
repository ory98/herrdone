package com.example.herrdone.repository;

import com.example.herrdone.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.sampled.BooleanControl;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Member deleteByEmail(String email);

    Boolean existsMemberByEmail(String email);
}
